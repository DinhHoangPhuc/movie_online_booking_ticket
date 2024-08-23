package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Director;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;
import com.online_booking_ticket.movie_online_booking_ticket.services.DirectorService;

@RestController
public class DirectorController {

    @Autowired
    DirectorService directorService;

    @GetMapping("/directors/{directorId}")
    public ResponseEntity<Director> getDirector(@PathVariable int directorId) {
        return directorService.getDirectorById(directorId);
    }

    @GetMapping("/directors/{directorId}/movies")
    public ResponseEntity<List<Movie>> getMoviesByDirectorId(@PathVariable int directorId) {
        return directorService.getMoviesByDirectorId(directorId);
    }
}
