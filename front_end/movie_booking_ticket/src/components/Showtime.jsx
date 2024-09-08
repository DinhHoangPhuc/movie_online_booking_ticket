/* eslint-disable react/prop-types */
import { useEffect, useState, useContext } from 'react';
import { AuthContext } from '../context/AuthContext';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Showtimes({ movie }) {
  const [cinemas, setCinemas] = useState([]);
  const navigate = useNavigate();
  const { isLoggedIn} = useContext(AuthContext);

  useEffect(() => {
    const fetchCinemas = async () => {
      const cinemaData = await Promise.all(
        movie.showtimes.map(showtime => {
          return axios.get(`/showtimes/${showtime}/cinema`).then(response => response.data)}
        )
      );
      setCinemas(cinemaData);
    };

    fetchCinemas();
  }, [movie]);

  // useEffect(() => {
  //   const fetchCinemas = async () => {
  //     for (const showtime of movie.showtimes) {
  //       const response = await axios.get(`/showtimes/${showtime}/cinema`);
  //       setCinemas(prevCinemas => [...prevCinemas, response.data]);
  //       // console.log(response.data)
  //     }
  //   };

  //   setCinemas([]);
  //   fetchCinemas();
  // }, [movie]);

  // console.log("Cinemas " + cinemas.length)
  // console.log("Showtimes after map " + movie.showtimes)
  // console.log(cinemas[0])
  // console.log(cinemas[1])

  const handleBookingClick = (showtime, cinema, startTimeString, startDate) => {
    if (isLoggedIn) {
      // User is logged in, navigate to booking page
      navigate(`/booking/${showtime.id}`, { state: { movie, cinema, startTimeString, startDate } });
    } else {
      // User is not logged in, redirect to login page
      navigate('/login');
    }
  };

  return (
    <div>
      {movie.showtimes.map((showtime, index) => {
        const cinema = cinemas[index] || {};
        const startDate = new Date(cinema.startTime);

        const startTimeString = startDate.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });

        return (
          <div key={index} className="flex flex-row justify-between border-b border-gray-200 py-2 px-5">
            <span>{cinema.name}</span>
            <span>{startDate.toLocaleDateString('en-GB', { day: 'numeric', month: 'long', year: 'numeric' })}</span>
            
            <span
              className='p-2 border border-orange-300 hover:bg-orange-400 rounded-xl cursor-pointer'
              onClick={() => handleBookingClick(showtime, cinema, startTimeString, startDate)}
            >
              {startTimeString}
            </span>
          </div>
        );
      })}
    </div>
  );
}

export default Showtimes;
