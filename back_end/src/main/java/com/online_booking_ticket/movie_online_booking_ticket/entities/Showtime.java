package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.Date;
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
public class Showtime {

    private int id;

    @JsonBackReference
    private Movie movie;

    @JsonBackReference
    private Screen screen;

    @JsonManagedReference
    private List<Booking> bookings;

    private Date startTime;

    private Date endTime;
}
