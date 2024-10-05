package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Cinema;

public interface CinemaRepo extends MongoRepository<Cinema, String> {

//    @Query("SELECT c FROM Cinema c JOIN c.screens s WHERE s.id = :screenId")
//    Cinema findByScreenId(@Param("screenId") int screenId);

}
