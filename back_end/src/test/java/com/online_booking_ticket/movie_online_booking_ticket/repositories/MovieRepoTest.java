package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import com.online_booking_ticket.movie_online_booking_ticket.config.MongoTestConfig;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@Import(MongoTestConfig.class)
class MovieRepoTest {

    @Autowired
    private MovieRepo movieRepo;

    @BeforeEach
    void setUp() {
        movieRepo.deleteAll();
    }

    @Test
    void testSaveMovie() {
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setDuration(148);
        movie.setReleaseDate(LocalDate.of(2010, 7, 16));
        movie.setDescription("A mind-bending thriller");
        movie.setPosterURL("poster_url");
        movie.setTrailerURL("trailer_url");
        movie.setDirectorID("director_id");
        movie.setActorIDs(new ArrayList<>(Arrays.asList("actor1", "actor2")));
        movie.setCountryID("country_id");
        movie.setGenreID("genre_id");

        Movie savedMovie = movieRepo.save(movie);

        assertThat(savedMovie).isNotNull();
        assertThat(savedMovie.getTitle()).isEqualTo("Inception");
        assertThat(savedMovie.getDuration()).isEqualTo(148);
        assertThat(savedMovie.getReleaseDate()).isEqualTo(LocalDate.of(2010, 7, 16));
        assertThat(savedMovie.getDescription()).isEqualTo("A mind-bending thriller");
        assertThat(savedMovie.getPosterURL()).isEqualTo("poster_url");
        assertThat(savedMovie.getTrailerURL()).isEqualTo("trailer_url");
        assertThat(savedMovie.getDirectorID()).isEqualTo("director_id");
        assertThat(savedMovie.getActorIDs()).containsExactly("actor1", "actor2");
        assertThat(savedMovie.getCountryID()).isEqualTo("country_id");
        assertThat(savedMovie.getGenreID()).isEqualTo("genre_id");
    }

}