package com.online_booking_ticket.movie_online_booking_ticket.services;


import java.util.List;

import com.online_booking_ticket.movie_online_booking_ticket.repositories.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Director;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepo directorRepo;

    public ResponseEntity<Director> getDirectorById(int directorId) {
        try {
            return new ResponseEntity<Director>(directorRepo.findById(directorId).get(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // return "Error occurred: " + e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Movie>> getMoviesByDirectorId(int directorId) {
        try {
            List<Movie> movies = directorRepo.getMoviesByDirectorId(directorId);
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // return "Error occurred: " + e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
