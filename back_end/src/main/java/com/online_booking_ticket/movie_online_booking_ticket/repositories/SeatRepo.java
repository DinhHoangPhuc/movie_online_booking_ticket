package com.online_booking_ticket.movie_online_booking_ticket.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer>{

    // @Query("SELECT s FROM Seat s JOIN s.screen sc JOIN sc.showTimes st WHERE st.id = :showtimeId")
    // List<Seat> findByShowtimeId(@Param("showtimeId") int showtimeId);

}
