package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    private int id;

    private String name;

    @JsonBackReference
    private List<Movie> movies;

}
