package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.sql.Date;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Actors")
public class Actor {

    public Actor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ActorID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "picture")
    private String picture;

    @ManyToOne
    @JoinColumn(name = "CountryID")
    @JsonBackReference
    private Country country;

    @ManyToMany(mappedBy = "actors")
    @JsonBackReference
    private List<Movie> movies;
}
