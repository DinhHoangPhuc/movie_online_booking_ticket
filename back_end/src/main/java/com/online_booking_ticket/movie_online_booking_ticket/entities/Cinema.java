package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Cinemas")
public class Cinema {

    @Id
    private String id;

    private String Name;

    private String Location;

    private int PhoneNumber;

    private String Description;

    private ArrayList<String> ImageURLs;

    private int TotalScreens;

    private ArrayList<String> ScreenIDs;
}
