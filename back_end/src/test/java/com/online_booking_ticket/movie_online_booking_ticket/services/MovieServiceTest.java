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

    @Test
    void updateMovie() {
        MovieRequest movieRequest = new MovieRequest();
        movieRequest.setTitle("Updated Movie");
        movieRequest.setDirectorID("newDirectorId");
        movieRequest.setActorIDs(new ArrayList<>(List.of("newActorId1", "newActorId2")));
        movieRequest.setGenreID("newGenreId");

        Movie oldMovie = new Movie();
        oldMovie.setId("movieId");
        oldMovie.setTitle("Old Movie");
        oldMovie.setDirectorID("oldDirectorId");
        oldMovie.setActorIDs(new ArrayList<>(List.of("oldActorId1", "oldActorId2")));
        oldMovie.setGenreID("oldGenreId");

        Movie updatedMovie = new Movie();
        updatedMovie.setId("movieId");
        updatedMovie.setTitle("Updated Movie");
        updatedMovie.setDirectorID("newDirectorId");
        updatedMovie.setActorIDs(new ArrayList<>(List.of("newActorId1", "newActorId2")));
        updatedMovie.setGenreID("newGenreId");

        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId("movieId");
        movieResponse.setTitle("Updated Movie");

        Director oldDirector = new Director();
        oldDirector.setId("oldDirectorId");
        oldDirector.setMovieIDs(new ArrayList<>());

        Director newDirector = new Director();
        newDirector.setId("newDirectorId");
        newDirector.setMovieIDs(new ArrayList<>());

        Actor oldActor1 = new Actor();
        oldActor1.setId("oldActorId1");
        oldActor1.setMovieIDs(new ArrayList<>());

        Actor oldActor2 = new Actor();
        oldActor2.setId("oldActorId2");
        oldActor2.setMovieIDs(new ArrayList<>());

        Actor newActor1 = new Actor();
        newActor1.setId("newActorId1");
        newActor1.setMovieIDs(new ArrayList<>());

        Actor newActor2 = new Actor();
        newActor2.setId("newActorId2");
        newActor2.setMovieIDs(new ArrayList<>());

        Genre oldGenre = new Genre();
        oldGenre.setId("oldGenreId");
        oldGenre.setMovieIDs(new ArrayList<>());

        Genre newGenre = new Genre();
        newGenre.setId("newGenreId");
        newGenre.setMovieIDs(new ArrayList<>());

        when(movieRepo.findById("movieId")).thenReturn(Optional.of(oldMovie));
        when(movieRepo.save(any(Movie.class))).thenReturn(updatedMovie);
        when(movieMapper.movieToMovieResponse(any(Movie.class))).thenReturn(movieResponse);

        when(directorRepo.findById("oldDirectorId")).thenReturn(Optional.of(oldDirector));
        when(directorRepo.findById("newDirectorId")).thenReturn(Optional.of(newDirector));
        when(actorRepo.findById("oldActorId1")).thenReturn(Optional.of(oldActor1));
        when(actorRepo.findById("oldActorId2")).thenReturn(Optional.of(oldActor2));
        when(actorRepo.findById("newActorId1")).thenReturn(Optional.of(newActor1));
        when(actorRepo.findById("newActorId2")).thenReturn(Optional.of(newActor2));
        when(genreRepo.findById("oldGenreId")).thenReturn(Optional.of(oldGenre));
        when(genreRepo.findById("newGenreId")).thenReturn(Optional.of(newGenre));

        MovieResponse result = movieService.updateMovie("movieId", movieRequest);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo("movieId");
        assertThat(result.getTitle()).isEqualTo("Updated Movie");

        verify(movieRepo, times(1)).findById("movieId");
        verify(movieRepo, times(1)).save(any(Movie.class));
        verify(directorRepo, times(1)).findById("oldDirectorId");
        verify(directorRepo, times(1)).findById("newDirectorId");
        verify(actorRepo, times(1)).findById("oldActorId1");
        verify(actorRepo, times(1)).findById("oldActorId2");
        verify(actorRepo, times(1)).findById("newActorId1");
        verify(actorRepo, times(1)).findById("newActorId2");
        verify(genreRepo, times(1)).findById("oldGenreId");
        verify(genreRepo, times(1)).findById("newGenreId");
    }

    @Test
    void updateReferences() {
        Movie newMovie = new Movie();
        newMovie.setId("movieId");
        newMovie.setDirectorID("newDirectorId");
        newMovie.setActorIDs(new ArrayList<>(List.of("newActorId1", "newActorId2")));
        newMovie.setGenreID("newGenreId");

        Movie oldMovie = new Movie();
        oldMovie.setId("movieId");
        oldMovie.setDirectorID("oldDirectorId");
        oldMovie.setActorIDs(new ArrayList<>(List.of("oldActorId1", "oldActorId2")));
        oldMovie.setGenreID("oldGenreId");

        Director oldDirector = new Director();
        oldDirector.setId("oldDirectorId");
        oldDirector.setMovieIDs(new ArrayList<>(List.of("movieId")));

        Director newDirector = new Director();
        newDirector.setId("newDirectorId");
        newDirector.setMovieIDs(new ArrayList<>());

        Actor oldActor1 = new Actor();
        oldActor1.setId("oldActorId1");
        oldActor1.setMovieIDs(new ArrayList<>(List.of("movieId")));

        Actor oldActor2 = new Actor();
        oldActor2.setId("oldActorId2");
        oldActor2.setMovieIDs(new ArrayList<>(List.of("movieId")));

        Actor newActor1 = new Actor();
        newActor1.setId("newActorId1");
        newActor1.setMovieIDs(new ArrayList<>());

        Actor newActor2 = new Actor();
        newActor2.setId("newActorId2");
        newActor2.setMovieIDs(new ArrayList<>());

        Genre oldGenre = new Genre();
        oldGenre.setId("oldGenreId");
        oldGenre.setMovieIDs(new ArrayList<>(List.of("movieId")));

        Genre newGenre = new Genre();
        newGenre.setId("newGenreId");
        newGenre.setMovieIDs(new ArrayList<>());

        when(directorRepo.findById("oldDirectorId")).thenReturn(Optional.of(oldDirector));
        when(directorRepo.findById("newDirectorId")).thenReturn(Optional.of(newDirector));
        when(actorRepo.findById("oldActorId1")).thenReturn(Optional.of(oldActor1));
        when(actorRepo.findById("oldActorId2")).thenReturn(Optional.of(oldActor2));
        when(actorRepo.findById("newActorId1")).thenReturn(Optional.of(newActor1));
        when(actorRepo.findById("newActorId2")).thenReturn(Optional.of(newActor2));
        when(genreRepo.findById("oldGenreId")).thenReturn(Optional.of(oldGenre));
        when(genreRepo.findById("newGenreId")).thenReturn(Optional.of(newGenre));

        movieService.updateReferences(newMovie, oldMovie);

        verify(directorRepo, times(1)).findById("oldDirectorId");
        verify(directorRepo, times(1)).findById("newDirectorId");
        verify(directorRepo, times(1)).save(oldDirector);
        verify(directorRepo, times(1)).save(newDirector);

        verify(actorRepo, times(1)).findById("oldActorId1");
        verify(actorRepo, times(1)).findById("oldActorId2");
        verify(actorRepo, times(1)).findById("newActorId1");
        verify(actorRepo, times(1)).findById("newActorId2");
        verify(actorRepo, times(1)).save(oldActor1);
        verify(actorRepo, times(1)).save(oldActor2);
        verify(actorRepo, times(1)).save(newActor1);
        verify(actorRepo, times(1)).save(newActor2);

        verify(genreRepo, times(1)).findById("oldGenreId");
        verify(genreRepo, times(1)).findById("newGenreId");
        verify(genreRepo, times(1)).save(oldGenre);
        verify(genreRepo, times(1)).save(newGenre);
    }
}