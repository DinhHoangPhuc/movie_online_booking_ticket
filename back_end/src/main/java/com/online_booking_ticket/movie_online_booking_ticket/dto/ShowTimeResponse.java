package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowTimeResponse {
    private String id;

    private MovieInShowtimeResponse movie;

    private CinemaInShowtimeResponse Cineama;

    private LocalDate Date;

    private LocalTime StartTime;

    private LocalTime EndTime;
}
