package com.online_booking_ticket.movie_online_booking_ticket.controllers;


import com.online_booking_ticket.movie_online_booking_ticket.dto.GenreRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.GenreResponse;
import com.online_booking_ticket.movie_online_booking_ticket.instant.ControllerPath;
import com.online_booking_ticket.movie_online_booking_ticket.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerPath.GENRE_CONTROLLER)
public class GenreController {

    @Autowired
    GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreResponse> addGenre(@RequestBody GenreRequest genreRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(genreService.addGenre(genreRequest));
    }
}
