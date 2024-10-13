package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CinemaInShowtimeResponse {
    private String CinemaID;
    private String CinemaName;

    private String ScreenID;
    private int ScreenNumber;
}
