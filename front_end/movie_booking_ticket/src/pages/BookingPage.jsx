/* eslint-disable no-unused-vars */
import React, { useEffect, useState, useRef, useContext } from 'react';
import { useParams, useLocation, useNavigate } from 'react-router';
import axios from 'axios';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './booking.css';
import SockJS from 'sockjs-client';
import { Client } from '@stomp/stompjs';
import { AuthContext } from '../context/AuthContext';

function BookingPage() {
    const { id } = useParams();
    const location = useLocation();
    const navigate = useNavigate();
    const { movie, cinema, startTimeString, startDate } = location.state;
    const [screen, setScreen] = useState(null);
    const [selectedSeats, setSelectedSeats] = useState([]);
    const [totalPrice, setTotalPrice] = useState(0);
    const stompClientRef = useRef(null);
    const [seat, setSeat] = useState({});
    const [seatStatuses, setSeatStatuses] = useState({});
    const { logout } = useContext(AuthContext);

    const email = localStorage.getItem('name');

    useEffect(() => {
        axios.get(`/showtimes/${id}/screen`)
            .then(response => setScreen(response.data))
            .catch(error => console.error(error));
    }, [id]);

    useEffect(() => {
        const stompClient = new Client({
            brokerURL: 'http://localhost:8080/ws',
            reconnectDelay: 5000,
            debug: (str) => {
                console.log(str);
            },
            onConnect: () => {
                console.log('Connected to WebSocket');
                stompClient.subscribe('/topic/seats', (response) => {
                    console.log('Received message:', response.body);
                    const message = JSON.parse(response.body);
                    const { seatId, email: messageEmail } = message;
                    setSeatStatuses(prevStatuses => ({
                        ...prevStatuses,
                        [seatId]: messageEmail === email ? 'rgb(37 99 235)' : 'rgb(156 163 175)'
                    }));
                });

                stompClient.subscribe('/topic/unSetSeats', (response) => {
                    console.log('Received unset message:', response.body);
                    const message = JSON.parse(response.body);
                    const { seatId } = message;
                    setSeatStatuses(prevStatuses => {
                        const newStatuses = { ...prevStatuses };
                        delete newStatuses[seatId];
                        return newStatuses;
                    });
                });
            },
            onStompError: (frame) => {
                console.error('Broker reported error: ' + frame.headers['message']);
                console.error('Additional details: ' + frame.body);
            },
        });

        stompClient.activate();
        stompClientRef.current = stompClient;

        return () => {
            stompClient.deactivate();
        };
    }, []);

    const sendMessage = (seat, destination) => {
        const stompClient = stompClientRef.current;
        if (stompClient && stompClient.connected) {
            console.log('Sending message:', seat);
            stompClient.publish({
                destination: destination,
                body: JSON.stringify(seat),
            });
        } else {
            console.error('Stomp client is not connected');
        }
    };

    if (!screen) {
        return <div>Loading...</div>;
    }

    // Create a 2D array to represent the seat layout
    const seatLayout = Array.from({ length: screen.totalRows }, () => Array(screen.totalColumns).fill(null));
    console.log(screen);
    console.log(seatLayout);

    // Fill the seatLayout with seat data
    screen.seats.forEach(seat => {
        seatLayout[seat.rowNumber - 1][seat.seatNumber - 1] = seat;
    });

    // Get a list of booked seat ids for the selected showtime
    const bookedSeats = new Set(screen.showTimes.flatMap(showtime => 
        showtime.bookings.map(booking => booking.seat.id)
    ));

    const toggleSeatSelection = (seat) => {
        if (seatStatuses[seat.id] === 'rgb(156 163 175)') {
            toast.error('Ghế này đã được chọn bởi người khác');
            return;
        }

        if (selectedSeats.some(selectedSeat => selectedSeat.id === seat.id)) {
            // Remove the seat from selectedSeats if it's already selected
            setSelectedSeats(selectedSeats.filter(selectedSeat => selectedSeat.id !== seat.id));
            setTotalPrice(totalPrice - seat.price); // Update the total price
            setSeatStatuses(prevStatuses => {
                const newStatuses = { ...prevStatuses };
                delete newStatuses[seat.id];
                return newStatuses;
            });
            sendMessage({ seatId: seat.id, email: email }, '/app/unSetSeats');
        } else {
            // Add the seat to selectedSeats if it's not selected
            setSelectedSeats([...selectedSeats, seat]);
            setTotalPrice(totalPrice + seat.price); // Update the total price
            setSeat({ seatId: seat.id, email: email });
            sendMessage({ seatId: seat.id, email: email }, '/app/seats');
        }
    };

    const submitBooking = async () => {
        const bookingDetails = selectedSeats.map(seat => ({
            showtimeId: id,
            seatId: seat.id,
            totalAmount: seat.price,
        }));

        try {
            const responses = await Promise.all(bookingDetails.map(details =>
                axios.post('/bookings', details)
            ));

            const successResponses = responses.filter(response => response.status === 201);
            if (successResponses.length > 0) {
                navigate('/success', { state: { tickets: successResponses.map(response => response.data) } });
            }

            if(successResponses.some(response => response.status === 401)) {
                logout();
            }

            if(successResponses.some(response => response.status === 400)) {
                toast.error('Có lỗi xảy ra khi đặt vé. Vui lòng thử lại.');
            }
        } catch (error) {
            console.error(error.response.status);
            if (error.response) {
                if (error.response.status === 401) {
                    logout();
                } else if (error.response.status === 400) {
                    toast.error('Có lỗi xảy ra khi đặt vé. Vui lòng thử lại.');
                }
            } else {
                console.error('Not having error.reponse: ' + error);
            }
        }
    };

    return (
        <div className="booking-page">
            <div className="seat-selection">
                <div className="seat-layout mb-20">
                    {seatLayout.map((row, rowIndex) => (
                        <div key={rowIndex} className="seat-row">
                            {row.map((seat, seatIndex) => (
                                <div 
                                    key={seatIndex} 
                                    className={`seat ${seat && bookedSeats.has(seat.id) ? 'booked' : (selectedSeats.some(selectedSeat => selectedSeat.id === seat.id) ? 'selected' : 'available')} cursor-pointer`}
                                    style={{ backgroundColor: seat && seatStatuses[seat.id] ? seatStatuses[seat.id] : '' }}
                                    onClick={() => seat && !bookedSeats.has(seat.id) && toggleSeatSelection(seat)}
                                >
                                    {seat ? `${seat.rowNumber}-${seat.seatNumber}` : ''}
                                </div>
                            ))}
                        </div>
                    ))}
                </div>
                <h2 className='py-2 mb-10 border-b-4 border-orange-600 text-center'>Màn hình</h2>
                <div className='flex gap-6'>
                    <div className='flex gap-2'>
                        <div className='w-5 h-5 bg-orange-400 rounded-md'></div>
                        <span className='text-sm'>Ghế đã bán</span>
                    </div>
                    <div className='flex gap-2'>
                        <div className='w-5 h-5 bg-blue-600 rounded-md'></div>
                        <span className='text-sm'>Ghế đang chọn</span>
                    </div>
                    <div className='flex gap-2'>
                        <div className='w-5 h-5 bg-gray-400 rounded-md'></div>
                        <span className='text-sm'>Ghế người khác đang chọn</span>
                    </div>
                </div>
            </div>
            <div className="movie-info">
                {movie && (
                    <>
                        <strong className='text-lg text-center'>{movie.title}</strong>
                        <img src={movie.posterURL} alt={movie.title} className='' />
                        <p><strong>{cinema.name} - </strong> Rạp {screen.screenNumber} </p>
                        <p>Suất: <strong>{startTimeString} - {startDate.toLocaleDateString('en-GB', { day: 'numeric', month: 'long', year: 'numeric' })}</strong> </p>
                        <hr />
                        <p className='my-3'><strong>Tổng giá:</strong> {totalPrice} VND</p>
                        <hr />
                        <button
                            onClick={submitBooking}
                            disabled={selectedSeats.length === 0}
                            className='p-2 bg-orange-400 text-white rounded-lg cursor-pointer hover:bg-orange-500 mt-5 w-full'
                        >
                            Đặt vé
                        </button>
                    </>
                )}
            </div>
            <ToastContainer />
        </div>
    );
}

export default BookingPage;