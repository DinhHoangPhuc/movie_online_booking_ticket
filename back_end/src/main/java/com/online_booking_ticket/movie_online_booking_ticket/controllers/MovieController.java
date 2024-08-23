package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Director;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;
import com.online_booking_ticket.movie_online_booking_ticket.services.MovieService;
import com.online_booking_ticket.movie_online_booking_ticket.services.ShowtimeService;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    ShowtimeService showtimeService;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        // Movie movie = movieService.getMovieById(id).getBody();
        // List<Showtime> showtimes = movie.getShowTimes();
        // for (Showtime showtime : showtimes) {
        //     ResponseEntity<Cinema> cinema = showtimeService.findCinemasByShowtime(showtime.getId());
        //     showtime.setCinema(cinema.getBody());
        // }
        return movieService.getMovieById(id);
    }

    // @GetMapping("/movies/movies-with-showtimes")
    // public ResponseEntity<Page<Movie>> getMoviesWithShowTimes(
    //         @RequestParam(defaultValue = "1") int page,
    //         @RequestParam(defaultValue = "5") int size) {
    //     return movieService.getMoviesWithShowTimes(page, size);
    // }
    @GetMapping("/movies/movies-with-showtimes")
    public ResponseEntity<List<Movie>> getMoviesWithShowTimes() {
        return movieService.getMoviesWithShowTimes();
    }

    @GetMapping("/movies/movies-without-showtimes")
    public ResponseEntity<List<Movie>> getMoviesWithoutShowtimes() {
        return movieService.getMoviesWithoutShowtimes();
    }

    @GetMapping("/movies/{movieId}/director")
    public ResponseEntity<Director> getDirectorByMovieId(@PathVariable int movieId) {
        return movieService.getDirectorByMovieId(movieId);
    }
}
