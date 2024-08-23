package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Actor;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;
import com.online_booking_ticket.movie_online_booking_ticket.services.ActorService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ActorController {

    @Autowired
    private ActorService actorService;
    
    @GetMapping("/actors/{actorId}")
    public ResponseEntity<Actor> getActorById(@PathVariable int actorId) {
        return actorService.getActorById(actorId);
    }

    @GetMapping("/actors/{actorId}/movies")
    public ResponseEntity<List<Movie>> getMoviesByActorId(@PathVariable int actorId) {
        return actorService.getMoviesByActorId(actorId);
    }

}
