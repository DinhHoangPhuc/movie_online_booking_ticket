package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import com.online_booking_ticket.movie_online_booking_ticket.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Booking;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookingRepo extends MongoRepository<Booking, Integer> {

//    @Query("SELECT b FROM Booking b WHERE b.user = :user")
//    Optional<List<Booking>> findByUser(@Param("user") User user);

    @Query("{'UserID':?0}")
    Optional<List<Booking>> findItemByUserID(int UserID);
}
