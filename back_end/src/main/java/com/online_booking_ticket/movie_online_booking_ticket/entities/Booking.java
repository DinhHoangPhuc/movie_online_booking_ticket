package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Booking {

    private int id;

    private Date bookingDate;

    private int totalAmount;

    @JsonBackReference
    private User user;

    @JsonBackReference
    private Showtime showtime;

    @JsonManagedReference
    private Seat seat;

    @JsonBackReference
    private Payment payment;
}
