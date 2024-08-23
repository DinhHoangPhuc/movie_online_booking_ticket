package com.online_booking_ticket.movie_online_booking_ticket.services;

import java.util.List;

import com.online_booking_ticket.movie_online_booking_ticket.repositories.DirectorRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Director;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;

@Service
public class MovieService {

    @Autowired
    MovieRepo movieRepo;

    @Autowired
    DirectorRepo directorRepo;

    public ResponseEntity<List<Movie>> getMovies() {
        try {
            return new ResponseEntity<>(movieRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // return "Error occurred: " + e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // public ResponseEntity<Page<Movie>> getMoviesWithShowTimes(int page, int size) {
    //     try {
    //         Pageable pageable = PageRequest.of(page, size);
    //         return new ResponseEntity<Page<Movie>>(movieRepo.findAllWithShowTimes(pageable), HttpStatus.OK);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         // return "Error occurred: " + e.getMessage();
    //         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    //     }
    // }

    public ResponseEntity<List<Movie>> getMoviesWithShowTimes() {
        try {
            return new ResponseEntity<List<Movie>>(movieRepo.findAllWithShowTimes(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // return "Error occurred: " + e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Movie>> getMoviesWithoutShowtimes() {
        try {
            return new ResponseEntity<List<Movie>>(movieRepo.findAllWithoutShowtimes(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // return "Error occurred: " + e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Movie> getMovieById(int id) {
        try {
            return new ResponseEntity<Movie>(movieRepo.findById(id).get(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // return "Error occurred: " + e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Director> getDirectorByMovieId(int movieId) {
        try {
            return new ResponseEntity<Director>(movieRepo.findDirectorByMovieId(movieId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // return "Error occurred: " + e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Movie> addMovie(Movie movie) {
        try {
            return new ResponseEntity<Movie>(movieRepo.save(movie), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            // return "Error occurred: " + e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Movie> updateMovie(Movie movie) {
        try {
            return new ResponseEntity<Movie>(movieRepo.save(movie), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // return "Error occurred: " + e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteMovie(int id) {
        try {
            movieRepo.deleteById(id);
            return new ResponseEntity<String>("Movie deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // return "Error occurred: " + e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
