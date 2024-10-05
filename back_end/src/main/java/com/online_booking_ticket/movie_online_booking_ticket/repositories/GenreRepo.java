package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreRepo extends MongoRepository<Genre, String> {
}
