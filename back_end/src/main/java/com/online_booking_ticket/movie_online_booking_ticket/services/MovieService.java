package com.online_booking_ticket.movie_online_booking_ticket.services;

import java.util.List;
import java.util.stream.Collectors;

import com.online_booking_ticket.movie_online_booking_ticket.dto.MovieById;
import com.online_booking_ticket.movie_online_booking_ticket.dto.MovieWithShowtime;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Actor;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Genre;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.ActorRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.DirectorRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.GenreRepo;
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

    @Autowired
    ActorRepo actorRepo;

    @Autowired
    GenreRepo genreRepo;

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

    public ResponseEntity<List<MovieWithShowtime>> getMoviesWithShowTimes() {
        try {
            return new ResponseEntity<List<MovieWithShowtime>>(movieRepo.findAllWithShowTimes(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // return "Error occurred: " + e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<MovieWithShowtime>> getMoviesWithoutShowtimes() {
        try {
            return new ResponseEntity<List<MovieWithShowtime>>(movieRepo.findAllWithoutShowtimes(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // return "Error occurred: " + e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<MovieById> getMovieById(int id) {
        try {
            Movie movie = movieRepo.findById(id).get();
            List<Actor> actors = movie.getActors()
                    .stream()
                    .map(actorId -> actorRepo.findById(actorId).get())
                    .collect(Collectors.toList());
            List<Genre> genres = movie.getGenres()
                    .stream()
                    .map(genreId -> genreRepo.findById(genreId).get())
                    .collect(Collectors.toList());
            MovieById movieById = new MovieById(
                    movie.getId(),
                    movie.getTitle(),
                    movie.getDuration(),
                    movie.getReleaseDate(),
                    movie.getRating(),
                    movie.getDescription(),
                    movie.getPosterURL(),
                    movie.getTrailerURL(),
                    movie.getDirectorID(),
                    movie.getCountryID(),
                    movie.getShowtimes(),
                    genres,
                    actors
            );
            return new ResponseEntity<MovieById>(movieById, HttpStatus.OK);
//            return new ResponseEntity<Movie>(movieRepo.findById(id).get(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // return "Error occurred: " + e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Director> getDirectorByMovieId(int movieId) {
        try {
            return new ResponseEntity<Director>(directorRepo.findItemByMovieID(movieId).orElse(null), HttpStatus.OK);
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
