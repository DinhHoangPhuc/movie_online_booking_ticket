package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Seat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeatRepo extends MongoRepository<Seat, String> {

    // @Query("SELECT s FROM Seat s JOIN s.screen sc JOIN sc.showTimes st WHERE st.id = :showtimeId")
    // List<Seat> findByShowtimeId(@Param("showtimeId") int showtimeId);

}
