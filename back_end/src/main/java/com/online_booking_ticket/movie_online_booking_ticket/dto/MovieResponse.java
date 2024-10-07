package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MovieResponse {
    private String id;

    private String Title;

    private int Duration;

    private LocalDate ReleaseDate;

    private String Description;

    private String PosterURL;

    private String TrailerURL;

    private DirectorResponse Director;

    private List<ActorResponse> Actors;

    private CountryResponse Country;

    private GenreResponse Genre;
}
