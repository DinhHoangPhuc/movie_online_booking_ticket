package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.CinemaRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.CinemaResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Cinema;

public class CinemaMapper {
    public static CinemaResponse toCinemaResponse(Cinema cinema) {
        CinemaResponse cinemaResponse = new CinemaResponse();
        cinemaResponse.setId(cinema.getId());
        cinemaResponse.setName(cinema.getName());
        cinemaResponse.setLocation(cinema.getLocation());
        cinemaResponse.setPhoneNumber(cinema.getPhoneNumber());
        cinemaResponse.setDescription(cinema.getDescription());
        cinemaResponse.setImageURLs(cinema.getImageURLs());
        cinemaResponse.setTotalScreens(cinema.getTotalScreens());
        cinemaResponse.setScreenIDs(cinema.getScreenIDs());
        return cinemaResponse;
    }

    public static Cinema toCinema(CinemaRequest cinemaRequest) {
        Cinema cinema = new Cinema();
        cinema.setName(cinemaRequest.getName());
        cinema.setLocation(cinemaRequest.getLocation());
        cinema.setPhoneNumber(cinemaRequest.getPhoneNumber());
        cinema.setDescription(cinemaRequest.getDescription());
        cinema.setImageURLs(cinemaRequest.getImageURLs());
        return cinema;
    }
}
