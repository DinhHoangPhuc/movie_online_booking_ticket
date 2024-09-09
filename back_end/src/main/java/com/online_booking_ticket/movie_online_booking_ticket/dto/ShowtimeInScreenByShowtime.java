package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowtimeInScreenByShowtime {
    private int id;

    private List<BookingInShowtimes> Bookings;

    private Date StartTime;

    private Date EndTime;
}
