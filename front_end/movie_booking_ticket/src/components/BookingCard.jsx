/* eslint-disable react/prop-types */
// eslint-disable-next-line no-unused-vars
import React from 'react';
import { FaCheckCircle } from 'react-icons/fa';
import { useNavigate } from 'react-router-dom';

function BookingCard({ ticket, index }) {
  const navigate = useNavigate();

  return (
    <div key={index} className="bg-white shadow-md rounded-lg p-6 mb-4 w-full max-w-md border border-green-500">
            <div className="flex items-center mb-2">
              <FaCheckCircle className="text-green-500 mr-2" size={24} />
              <h2 className="text-xl font-semibold">{ticket.movieName}</h2>
            </div>
            <p><strong>Mã vé:</strong> {ticket.ticketId}</p>
            <p><strong>Rạp:</strong> {ticket.cinemaName}</p>
            <p><strong>Phòng:</strong> {ticket.screenNumber}</p>
            <p><strong>Ghế:</strong> {ticket.seatNumber}</p>
            <p><strong>Thời gian bắt đầu chiếu:</strong> {new Date(ticket.startTime).toLocaleString()}</p>
            <p><strong>Thời gian kết thúc chiếu:</strong> {new Date(ticket.endTime).toLocaleString()}</p>
            <p><strong>Tổng tiền:</strong> {ticket.totalAmount} VND</p>
            <p><strong>Ngày đặt:</strong> {new Date(ticket.bookingDate).toLocaleDateString()}</p>
            <p><strong>Tên người đặt:</strong> {ticket.userName}</p>
            <button
              onClick={() => navigate('/')}
              className="mt-4 p-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600 w-full"
            >
              Quay lại trang chủ
            </button>
          </div>
  );
}

export default BookingCard;