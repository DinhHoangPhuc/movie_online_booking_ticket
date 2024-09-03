package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private int id;

    private String title;

    private int duration;

    private Date releaseDate;

    private double rating;

    private String description;

    private String posterURL;

    private String trailerURL;

    @JsonBackReference
    private Director director;

    @JsonBackReference
    private Country country;

    @JsonManagedReference
    private List<Showtime> showTimes;

    @JsonManagedReference
    private List<Genre> genres;

    @JsonManagedReference
    private List<Actor> actors;
}