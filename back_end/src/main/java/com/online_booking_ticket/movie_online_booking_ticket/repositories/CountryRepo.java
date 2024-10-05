package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepo extends MongoRepository<Country, String> {
}
