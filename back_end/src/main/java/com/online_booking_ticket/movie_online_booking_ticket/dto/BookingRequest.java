package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {
    private int showtimeId;
    private int seatId;
    private int totalAmount;
}
