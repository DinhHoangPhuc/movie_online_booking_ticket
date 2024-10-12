package com.online_booking_ticket.movie_online_booking_ticket.service;

import com.online_booking_ticket.movie_online_booking_ticket.dto.ScreenRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.ScreenResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Cinema;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Screen;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Seat;
import com.online_booking_ticket.movie_online_booking_ticket.mapper.ScreenMapper;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.CinemaRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.ScreenRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class ScreenService {

    @Autowired
    private ScreenRepo screenRepo;

    @Autowired
    private CinemaRepo cinemaRepo;

    @Autowired
    private SeatRepo seatRepo;

    private int SEAT_PRICE = 70000;

    @Transactional
    public ScreenResponse addScreen(ScreenRequest screenRequest) {
        Screen screen = ScreenMapper.toScreen(screenRequest);
        screen.setShowtimeIDs(new ArrayList<>());

        Screen savedScreen = screenRepo.save(screen);
        updateCinema(savedScreen.getCinemaID(), savedScreen.getId());

        ArrayList<String> seatIDs = addSeatIDs(savedScreen);
        savedScreen.setSeatIDs(seatIDs);
        screenRepo.save(savedScreen);

        return ScreenMapper.toScreenResponse(savedScreen);
    }

    private Cinema getCinema(String cinemaID) {
        return cinemaRepo.findById(cinemaID).orElseThrow(() -> new RuntimeException("Cinema not found"));
    }

    private void updateCinema(String cinemaID, String screenID) {
        Cinema cinema = getCinema(cinemaID);
        cinema.getScreenIDs().add(screenID);
        cinema.setTotalScreens(cinema.getTotalScreens() + 1);
        cinemaRepo.save(cinema);
    }

    private ArrayList<String> addSeatIDs(Screen screen) {
        ArrayList<String> seatIDs = new ArrayList<>();
        for (int i = 1; i <= screen.getTotalRows(); i++) {
            for (int j = 1; j <= screen.getTotalColumns(); j++) {
                Seat seat = new Seat();
                seat.setScreenID(screen.getId());
                seat.setRowNumber(i);
                seat.setColumnNumber(j);
                seat.setPrice(SEAT_PRICE);
                Seat savedSeat = seatRepo.save(seat);
                seatIDs.add(savedSeat.getId());
            }
        }
        return seatIDs;
    }
}
