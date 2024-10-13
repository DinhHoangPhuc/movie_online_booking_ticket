package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import com.online_booking_ticket.movie_online_booking_ticket.dto.ShowTimeRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.ShowTimeResponse;
import com.online_booking_ticket.movie_online_booking_ticket.instant.ControllerPath;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.online_booking_ticket.movie_online_booking_ticket.services.ShowtimeService;

import java.util.ArrayList;

@RestController
@RequestMapping(ControllerPath.SHOWTIME_CONTROLLER)
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    @PostMapping
    public ResponseEntity<ShowTimeResponse> addShowtime(@RequestBody @Valid ShowTimeRequest showTimeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(showtimeService.addShowtime(showTimeRequest));
    }

    @GetMapping
    public ResponseEntity<ArrayList<ShowTimeResponse>> getAllShowtimes() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(showtimeService.getAllShowtimes());
    }
}
