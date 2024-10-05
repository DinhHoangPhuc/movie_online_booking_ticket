package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Screens")
public class Screen {

    @Id
    private String id;

    private String CinemaID;

    private int ScreenNumber;

    private int TotalRows;

    private int TotalColumns;

    private ArrayList<String> SeatIDs;

    private ArrayList<String> ShowtimeIDs;
}
