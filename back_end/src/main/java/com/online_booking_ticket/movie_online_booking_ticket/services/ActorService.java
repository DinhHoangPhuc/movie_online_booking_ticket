package com.online_booking_ticket.movie_online_booking_ticket.services;

import java.util.List;

import com.online_booking_ticket.movie_online_booking_ticket.repositories.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Actor;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;

@Service
public class ActorService {

    @Autowired
    private ActorRepo actorRepo;

    public ResponseEntity<Actor> getActorById(int actorId) {
        try {
            return new ResponseEntity<Actor>(actorRepo.findById(actorId).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Movie>> getMoviesByActorId(int actorId) {
        try {
            return new ResponseEntity<>(actorRepo.findById(actorId).get().getMovies(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
