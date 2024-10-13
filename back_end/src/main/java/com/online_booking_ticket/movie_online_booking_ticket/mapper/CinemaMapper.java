package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.CinemaRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.CinemaResponse;
import com.online_booking_ticket.movie_online_booking_ticket.dto.ScreenInCinemaResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Cinema;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Screen;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.ScreenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CinemaMapper {

    @Autowired
    private ScreenRepo screenRepo;

    public CinemaResponse toCinemaResponse(Cinema cinema) {
        CinemaResponse cinemaResponse = new CinemaResponse();
        cinemaResponse.setId(cinema.getId());
        cinemaResponse.setName(cinema.getName());
        cinemaResponse.setLocation(cinema.getLocation());
        cinemaResponse.setPhoneNumber(cinema.getPhoneNumber());
        cinemaResponse.setDescription(cinema.getDescription());
        cinemaResponse.setImageURLs(cinema.getImageURLs());
        cinemaResponse.setTotalScreens(cinema.getTotalScreens());

        ArrayList<ScreenInCinemaResponse> screens = new ArrayList<>();

        for (String screenID : cinema.getScreenIDs()) {
            Screen screen = getScreenById(screenID);
            screens.add(new ScreenInCinemaResponse(screen.getId(), screen.getScreenNumber()));
        }

        cinemaResponse.setScreens(screens);

        return cinemaResponse;
    }

    public Cinema toCinema(CinemaRequest cinemaRequest) {
        Cinema cinema = new Cinema();
        cinema.setName(cinemaRequest.getName());
        cinema.setLocation(cinemaRequest.getLocation());
        cinema.setPhoneNumber(cinemaRequest.getPhoneNumber());
        cinema.setDescription(cinemaRequest.getDescription());
        cinema.setImageURLs(cinemaRequest.getImageURLs());
        return cinema;
    }

    private Screen getScreenById(String screenID) {
        return screenRepo.findById(screenID).orElseThrow(() -> new RuntimeException("Screen not found"));
    }
}
