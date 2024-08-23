// eslint-disable-next-line no-unused-vars
import React, { useEffect, useState } from "react";
import axios from "axios";
import BookingCard from "../components/BookingCard";
import { toast, ToastContainer } from "react-toastify";

function BookingHistoryPage() {
  const [bookings, setBookings] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchBookings();
  }, []);

  const fetchBookings = async () => {
    try {
      const response = await axios.get("/bookings/history");
      setBookings(response.data);
    } catch (error) {
        toast.error("Lỗi", {
            position: "top-right",
        });
      console.error(error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen">
      <h1 className="text-center mb-4 text-xl font-bold mt-4">Booking History</h1>
      {loading ? (
        <p>Loading...</p>
      ) : (
        <div className="flex flex-col items-center">
          {bookings.map((booking, index) => (
            <BookingCard key={index} ticket={booking} index={index} />
          ))}
        </div>
      )}
      <ToastContainer />
    </div>
  );
}

export default BookingHistoryPage;