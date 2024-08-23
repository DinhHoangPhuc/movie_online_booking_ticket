// eslint-disable-next-line no-unused-vars
import React from 'react';
import { useLocation } from 'react-router-dom';
// import { FaCheckCircle } from 'react-icons/fa';
import BookingCard from '../components/BookingCard';

function BookingSuccessPage() {
  const location = useLocation();
//   const navigate = useNavigate();
  const { tickets } = location.state || { tickets: [] };

  return (
    <div className="min-h-screen bg-gray-100 flex flex-col items-center justify-center p-4">
      <h1 className="text-3xl font-bold mb-6">Đặt vé thành công</h1>
      {tickets.length > 0 ? (
        tickets.map((ticket, index) => (
            <BookingCard key={index} ticket={ticket} index={index} />
        ))
      ) : (
        <p className="text-lg">Không tìm thấy vé</p>
      )}
    </div>
  );
}

export default BookingSuccessPage;