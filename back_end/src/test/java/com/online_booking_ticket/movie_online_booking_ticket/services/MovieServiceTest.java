package com.online_booking_ticket.movie_online_booking_ticket.services;

import com.online_booking_ticket.movie_online_booking_ticket.dto.MovieRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.MovieResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Actor;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Director;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Genre;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;
import com.online_booking_ticket.movie_online_booking_ticket.mapper.MovieMapper;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.ActorRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.DirectorRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.GenreRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.MovieRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MovieServiceTest {

    @Mock
    private MovieRepo movieRepo;

    @Mock
    private DirectorRepo directorRepo;

    @Mock
    private ActorRepo actorRepo;

    @Mock
    private GenreRepo genreRepo;

    @Mock
    private MovieMapper movieMapper;

    @InjectMocks
    private MovieService movieService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addMovie() {
        MovieRequest movieRequest = new MovieRequest();
        movieRequest.setTitle("Test Movie");
        movieRequest.setDirectorID("directorId");
        movieRequest.setActorIDs(new ArrayList<>(List.of("actorId1", "actorId2")));
        movieRequest.setGenreID("genreId");

        Movie movie = new Movie();
        movie.setId("movieId");
        movie.setTitle("Test Movie");
        movie.setDirectorID("directorId");
        movie.setActorIDs(new ArrayList<>(List.of("actorId1", "actorId2")));
        movie.setGenreID("genreId");

        Movie savedMovie = new Movie();
        savedMovie.setId("movieId");
        savedMovie.setTitle("Test Movie");

        Director director = new Director();
        director.setId("directorId");
        director.setMovieIDs(new ArrayList<>());

        Actor actor1 = new Actor();
        actor1.setId("actorId1");
        actor1.setMovieIDs(new ArrayList<>());

        Actor actor2 = new Actor();
        actor2.setId("actorId2");
        actor2.setMovieIDs(new ArrayList<>());

        Genre genre = new Genre();
        genre.setId("genreId");
        genre.setMovieIDs(new ArrayList<>());

        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId("movieId");
        movieResponse.setTitle("Test Movie");

        when(movieMapper.movieRequestToMovie(any(MovieRequest.class))).thenReturn(movie);
        when(movieRepo.save(any(Movie.class))).thenReturn(savedMovie);
        when(directorRepo.findById("directorId")).thenReturn(Optional.of(director));
        when(actorRepo.findById("actorId1")).thenReturn(Optional.of(actor1));
        when(actorRepo.findById("actorId2")).thenReturn(Optional.of(actor2));
        when(genreRepo.findById("genreId")).thenReturn(Optional.of(genre));
        when(movieMapper.movieToMovieResponse(any(Movie.class))).thenReturn(movieResponse);

        MovieResponse result = movieService.addMovie(movieRequest);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo("movieId");
        assertThat(result.getTitle()).isEqualTo("Test Movie");

        verify(movieRepo, times(1)).save(movie);
        verify(directorRepo, times(1)).save(director);
        verify(actorRepo, times(1)).save(actor1);
        verify(actorRepo, times(1)).save(actor2);
        verify(genreRepo, times(1)).save(genre);
    }
}