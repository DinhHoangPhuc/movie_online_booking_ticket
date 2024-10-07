package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import com.online_booking_ticket.movie_online_booking_ticket.dto.ActorRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.ActorResponse;
import com.online_booking_ticket.movie_online_booking_ticket.instant.ControllerPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.online_booking_ticket.movie_online_booking_ticket.services.ActorService;

import java.util.List;


@RestController
@RequestMapping(ControllerPath.ACTOR_CONTROLLER)
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping
    public ResponseEntity<ActorResponse> addActor(@RequestBody ActorRequest actorRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(actorService.addActor(actorRequest));
    }

    @GetMapping
    public ResponseEntity<List<ActorResponse>> getActors() {
        return ResponseEntity.status(HttpStatus.OK).body(actorService.getActors());
    }
}
