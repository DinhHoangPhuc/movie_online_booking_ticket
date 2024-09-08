package com.online_booking_ticket.movie_online_booking_ticket.dto;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Showtime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieWithShowtime {
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

    private List<Integer> Genres;

    private List<Integer> Actors;

    private List<Showtime> ShowTimes;
}
