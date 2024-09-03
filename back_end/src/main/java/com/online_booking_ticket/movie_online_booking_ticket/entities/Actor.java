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
@Document("Actors")
public class Actor {

    @Id
    private int id;

    private String Name;

    private Date BirthDate;

    private String Picture;

    private int CountryID;

    private List<Integer> Movies;

//    @JsonBackReference
//    private Country country;
//
//    @JsonBackReference
//    private List<Movie> movies;
}
