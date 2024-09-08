package com.online_booking_ticket.movie_online_booking_ticket.dto;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Cinema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CinemaByShowtimeId extends Cinema {
    private Date startTime;

    public CinemaByShowtimeId(Cinema cinema, Date startTime) {
        super(cinema.getId(), cinema.getName(), cinema.getLocation(), cinema.getTotalScreens(), cinema.getScreens());
        this.startTime = startTime;
    }
}
