package com.online_booking_ticket.movie_online_booking_ticket.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    private int id;

    private int rowNumber;

    private int seatNumber;

    private int price;

    private String status;

    @JsonBackReference
    private Screen screen;

    @JsonBackReference
    private Booking booking;
}
