package com.online_booking_ticket.movie_online_booking_ticket.entities;

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
@Document("Countries")
public class Country {

    @Id
    private int id;

    private String Name;

    private List<Integer> Directors;

//    @JsonManagedReference
//    private List<Movie> movies;
//
//    @JsonManagedReference
//    private List<Actor> actors;
}
