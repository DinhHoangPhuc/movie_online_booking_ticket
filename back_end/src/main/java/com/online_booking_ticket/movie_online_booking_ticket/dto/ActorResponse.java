package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class ActorResponse {
    private String id;

    private String Name;

    private LocalDate BirthDate;

    private String Picture;

    private ArrayList<String> MovieIDs;

    private String CountryID;
}
