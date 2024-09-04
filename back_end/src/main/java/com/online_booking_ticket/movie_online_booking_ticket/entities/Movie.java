package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("Movies")
public class Movie {

    @Id
    private int id;

    private String Title;

    private int Duration;

    private Date ReleaseDate;

    private double Rating;

    private String Description;

    private String PosterURL;

    private String TrailerURL;

    private int DirectorID;

    private int CountryID;

//    @JsonManagedReference
//    private List<Showtime> showTimes;

    private List<Integer> Genres;

    private List<Integer> Actors;
}