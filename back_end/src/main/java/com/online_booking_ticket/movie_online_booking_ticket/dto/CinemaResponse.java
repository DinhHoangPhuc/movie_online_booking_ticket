package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CinemaResponse {
    private String id;

    private String Name;

    private String Location;

    private int PhoneNumber;

    private String Description;

    private ArrayList<String> ImageURLs;

    private int TotalScreens;

    private ArrayList<ScreenInCinemaResponse> Screens;
}
