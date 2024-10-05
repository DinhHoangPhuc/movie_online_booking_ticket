package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import com.online_booking_ticket.movie_online_booking_ticket.dto.DirectorRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.DirectorResponse;
import com.online_booking_ticket.movie_online_booking_ticket.instant.ControllerPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.online_booking_ticket.movie_online_booking_ticket.services.DirectorService;

@RestController
@RequestMapping(ControllerPath.DIRECTOR_CONTROLLER)
public class DirectorController {

    @Autowired
    DirectorService directorService;

    @PostMapping
    public ResponseEntity<DirectorResponse> addDirector(@RequestBody DirectorRequest directorRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(directorService.addDirector(directorRequest));
    }
}
