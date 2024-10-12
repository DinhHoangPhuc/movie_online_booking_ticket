package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ScreenResponse {
    private String id;

    private String CinemaID;

    private int ScreenNumber;

    private int TotalRows;

    private int TotalColumns;

    private ArrayList<String> SeatIDs;

    private ArrayList<String> ShowtimeIDs;
}
