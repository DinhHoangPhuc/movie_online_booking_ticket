package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.Data;

@Data
public class ScreenRequest {
    private String CinemaID;

    private int ScreenNumber;

    private int TotalRows;

    private int TotalColumns;
}
