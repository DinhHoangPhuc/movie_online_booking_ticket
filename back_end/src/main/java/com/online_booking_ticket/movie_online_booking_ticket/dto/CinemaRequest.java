package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CinemaRequest {
    private String Name;

    private String Location;

    private int PhoneNumber;

    private String Description;

    private ArrayList<String> ImageURLs;
}
