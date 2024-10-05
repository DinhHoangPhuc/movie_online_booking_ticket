package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class MovieDTO {
    private String id;

    private String Title;

    private int Duration;

    private LocalDate ReleaseDate;

    private String Description;

    private String PosterURL;

    private String TrailerURL;

    private String DirectorID;

    private ArrayList<String> ActorIDs;

    private String CountryID;

    private String GenreID;
}
