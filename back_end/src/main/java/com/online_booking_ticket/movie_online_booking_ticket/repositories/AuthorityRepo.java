package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Authority;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorityRepo extends MongoRepository<Authority, String> {
}
