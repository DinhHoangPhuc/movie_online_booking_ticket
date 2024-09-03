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
public class Director {

    private int id;

    private String name;

    private Date birthDate;

    private String picture;

    @JsonBackReference
    private Country country;

    @JsonManagedReference
    private List<Movie> movies;

    // getters and setters
}