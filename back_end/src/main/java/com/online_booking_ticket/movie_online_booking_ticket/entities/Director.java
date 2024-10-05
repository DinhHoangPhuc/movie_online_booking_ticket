package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Directors")
public class Director {

    @Id
    private String id;

    private String Name;

    private LocalDate BirthDate;

    private String Picture;

    private String CountryID;

    private ArrayList<String> MovieIDs;

}