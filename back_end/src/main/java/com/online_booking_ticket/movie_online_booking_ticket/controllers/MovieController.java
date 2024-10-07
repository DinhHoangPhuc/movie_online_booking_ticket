package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import com.online_booking_ticket.movie_online_booking_ticket.dto.MovieRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.MovieResponse;
import com.online_booking_ticket.movie_online_booking_ticket.instant.ControllerPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.online_booking_ticket.movie_online_booking_ticket.services.MovieService;

import java.util.List;

@RestController
@RequestMapping(ControllerPath.MOVIE_CONTROLLER)
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest movieRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.addMovie(movieRequest));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovies());
    }

}
