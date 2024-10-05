package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.time.LocalDate;
import java.util.ArrayList;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Actors")
public class Actor {

    @Id
    private String id;

    private String Name;

    private LocalDate BirthDate;

    private String Picture;

    private ArrayList<String> MovieIDs;

    private String CountryID;
}
