package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Countries")
@Getter
@Setter
public class Country {

    public Country() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CountryID")
    private int id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "country")
    @JsonManagedReference
    private List<Movie> movies;

    @OneToMany(mappedBy = "country")
    @JsonManagedReference
    private List<Actor> actors;

    // getters and setters
}
