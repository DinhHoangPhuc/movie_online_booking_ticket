package com.online_booking_ticket.movie_online_booking_ticket.dto;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingInShowtimes {
    private int id;
    private Date BookingDate;
    private int TotalAmount;
    private Seat Seat;
}
