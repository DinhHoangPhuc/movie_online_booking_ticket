package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Directors")
@Getter
@Setter
public class Director {

    public Director() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DirectorID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Birthdate")
    private Date birthDate;

    @Column(name = "Picture")
    private String picture;

    @ManyToOne
    @JoinColumn(name = "CountryID")
    @JsonBackReference
    private Country country;

    @OneToMany(mappedBy = "director")
    @JsonManagedReference
    private List<Movie> movies;

    // getters and setters
}