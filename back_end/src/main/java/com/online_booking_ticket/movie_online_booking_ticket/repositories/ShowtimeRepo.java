package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import java.time.LocalDate;
import java.util.List;


import com.online_booking_ticket.movie_online_booking_ticket.entities.Seat;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Showtime;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShowtimeRepo extends MongoRepository<Showtime, String> {
}
