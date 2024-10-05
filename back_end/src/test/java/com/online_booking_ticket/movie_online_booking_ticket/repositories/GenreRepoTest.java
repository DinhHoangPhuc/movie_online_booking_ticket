package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import com.online_booking_ticket.movie_online_booking_ticket.config.MongoTestConfig;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Genre;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.GenreRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@Import(MongoTestConfig.class)
public class GenreRepoTest {
    @Autowired
    private GenreRepo genreRepo;

    @BeforeEach
    public void setUp() {
        genreRepo.deleteAll();
    }

    @Test
    public void testSaveGenre() {
        Genre genre = new Genre();
        genre.setName("Action");
        genre.setMovieIDs(new ArrayList<>(Arrays.asList("1", "2", "3")));

        Genre savedGenre = genreRepo.save(genre);

        assertThat(savedGenre).isNotNull();
        assertThat(savedGenre.getName()).isEqualTo("Action");
        assertThat(savedGenre.getMovieIDs()).containsExactly("1", "2", "3");
    }
}
