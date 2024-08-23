package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Cinema;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Screen;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Seat;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Showtime;
import com.online_booking_ticket.movie_online_booking_ticket.services.ShowtimeService;

@RestController
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    // @GetMapping("/showtimes/{showtimeid}/cinema")
    // public ResponseEntity<Showtime> getCinema(@PathVariable int showtimeid) {
    //     return showtimeService.findCinemasByShowtime(showtimeid);
    //     // return null;
    // }

    @GetMapping("/showtimes/{showtimeid}/cinema")
    public ResponseEntity<Cinema> getCinemaByShowtimeId(@PathVariable int showtimeid) {
        return showtimeService.findCinemasByShowtime(showtimeid);
        // return null;
    }

    @GetMapping("/showtimes")
    public ResponseEntity<List<Showtime>> getShowtimes() {
        return showtimeService.getShowtimes();
    }

    @GetMapping("/showtimes/{showtimeid}/seats")
    public ResponseEntity<List<Seat>> getSeatsByShowtimeId(@PathVariable int showtimeid) {
        return showtimeService.findSeatsByShowtime(showtimeid);
    }

    @GetMapping("/showtimes/{showtimeId}/screen")
    public ResponseEntity<Screen> getScreenByShowtimeId(@PathVariable int showtimeId) {
        return showtimeService.findScreenByShowtime(showtimeId);
    }
}
