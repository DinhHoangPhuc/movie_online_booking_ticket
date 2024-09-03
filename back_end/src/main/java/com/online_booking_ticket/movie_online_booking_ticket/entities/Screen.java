package com.online_booking_ticket.movie_online_booking_ticket.entities;

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
public class Screen {

    private int id;

    @JsonBackReference
    private Cinema cinema;

    private int screenNumber;

    private int totalRows;

    private int totalColumns;

    @JsonManagedReference
    private List<Showtime> showTimes;

    @JsonManagedReference
    private List<Seat> seats;
}
