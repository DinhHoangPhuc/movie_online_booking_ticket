package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import java.util.List;


import com.online_booking_ticket.movie_online_booking_ticket.entities.Seat;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Showtime;

public interface ShowtimeRepo{
    
//    @Query("SELECT s FROM Seat s JOIN s.screen sc JOIN sc.showTimes st WHERE st.id = :showtimeId")
//    List<Seat> findSeatsByShowtimeId(@Param("showtimeId") int showtimeId);
}
