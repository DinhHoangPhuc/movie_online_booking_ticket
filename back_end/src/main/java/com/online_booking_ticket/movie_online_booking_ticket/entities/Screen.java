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
@Document("Screens")
public class Screen {

    @Id
    private int id;

    private int CinemaID;

    private int ScreenNumber;

    private int TotalRows;

    private int TotalColumns;

//    @JsonManagedReference
//    private List<Showtime> showTimes;

    private List<Integer> Seats;
}
