package com.online_booking_ticket.movie_online_booking_ticket.services;

import com.online_booking_ticket.movie_online_booking_ticket.dto.CinemaRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.CinemaResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Cinema;
import com.online_booking_ticket.movie_online_booking_ticket.mapper.CinemaMapper;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.CinemaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepo cinemaRepo;

    @Autowired
    private CinemaMapper cinemaMapper;


    public CinemaResponse addCinema(CinemaRequest cinemaRequest) {
        Cinema cinema = cinemaMapper.toCinema(cinemaRequest);
        cinema.setScreenIDs(new ArrayList<>());
        cinema.setTotalScreens(0);

        return cinemaMapper.toCinemaResponse(cinemaRepo.save(cinema));
    }

    public ArrayList<CinemaResponse> getAllCinemas() {
        ArrayList<CinemaResponse> cinemaResponses = new ArrayList<>();
        for (Cinema cinema : cinemaRepo.findAll()) {
            cinemaResponses.add(cinemaMapper.toCinemaResponse(cinema));
        }
        return cinemaResponses;
    }
}
