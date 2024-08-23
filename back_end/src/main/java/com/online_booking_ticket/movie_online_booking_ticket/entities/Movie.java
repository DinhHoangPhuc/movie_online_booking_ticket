package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Movies")
@Getter
@Setter
public class Movie {

    public Movie() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MovieID")
    private int id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Duration")
    private int duration;

    @Column(name = "Releasedate")
    private Date releaseDate;

    @Column(name = "Rating")
    private double rating;

    @Column(name = "Description")
    private String description;

    @Column(name = "PosterURL")
    private String posterURL;

    @Column(name = "TrailerURL")
    private String trailerURL;

    @ManyToOne
    @JoinColumn(name = "DirectorID")
    @JsonBackReference
    private Director director;

    @ManyToOne
    @JoinColumn(name = "CountryID")
    @JsonBackReference
    private Country country;

    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    private List<Showtime> showTimes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "moviegenres",
            joinColumns = @JoinColumn(name = "movieid", referencedColumnName = "movieid"),
            inverseJoinColumns = @JoinColumn(name = "genreid", referencedColumnName = "genreid"))
    @JsonManagedReference
    private List<Genre> genres;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movieactors",
            joinColumns = @JoinColumn(name = "movieid", referencedColumnName = "movieid"),
            inverseJoinColumns = @JoinColumn(name = "actorid", referencedColumnName = "actorid"))
    @JsonManagedReference
    private List<Actor> actors;
    // getters and setters
}