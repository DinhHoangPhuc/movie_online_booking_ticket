package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class DirectorResponse {
    private String id;

    private String Name;

    private LocalDate BirthDate;

    private String Picture;

    private String CountryID;

    private ArrayList<String> MovieIDs;
}
