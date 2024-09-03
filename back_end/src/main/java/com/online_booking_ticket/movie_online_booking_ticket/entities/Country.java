package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {

    private int id;

    private String name;

    @JsonManagedReference
    private List<Movie> movies;

    @JsonManagedReference
    private List<Actor> actors;
}
