package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import com.online_booking_ticket.movie_online_booking_ticket.entities.User;
import org.springframework.stereotype.Repository;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Booking;


@Repository
public interface BookingRepo {

//    @Query("SELECT b FROM Booking b WHERE b.user = :user")
//    Optional<List<Booking>> findByUser(@Param("user") User user);
}
