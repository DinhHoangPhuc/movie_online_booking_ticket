package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Showtimes")
public class Showtime {

    @Id
    private String id;

    private String MovieID;

    private String ScreenID;

    private LocalDate Date;

    private LocalTime StartTime;

    private LocalTime EndTime;
}
