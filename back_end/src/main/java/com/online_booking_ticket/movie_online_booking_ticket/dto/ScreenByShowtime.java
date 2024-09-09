package com.online_booking_ticket.movie_online_booking_ticket.dto;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Screen;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScreenByShowtime {
    private int id;

    private int ScreenNumber;

    private int TotalRows;

    private int TotalColumns;

    private List<ShowtimeInScreenByShowtime> Showtimes;

    private List<Seat> Seats;
}
