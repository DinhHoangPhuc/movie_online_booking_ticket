package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import com.online_booking_ticket.movie_online_booking_ticket.dto.CinemaRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.CinemaResponse;
import com.online_booking_ticket.movie_online_booking_ticket.instant.ControllerPath;
import com.online_booking_ticket.movie_online_booking_ticket.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerPath.CINEMA_CONTROLLER)
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @PostMapping
    public ResponseEntity<CinemaResponse> addCinema(@RequestBody CinemaRequest cinemaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cinemaService.addCinema(cinemaRequest));
    }
}
