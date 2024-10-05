package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import com.online_booking_ticket.movie_online_booking_ticket.config.MongoTestConfig;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Director;
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
class DirectorRepoTest {

    @Autowired
    private DirectorRepo directorRepo;

    @BeforeEach
    void setUp() {
        directorRepo.deleteAll();
    }

    @Test
    public void addDirector() {
        Director director = new Director();
        director.setName("John Doe");
        director.setBirthDate(LocalDate.of(1990, 1, 1));
        director.setPicture("picture_url");
        director.setMovieIDs(new ArrayList<>(Arrays.asList("1", "2", "3")));
        director.setCountryID("country_id");

        Director savedDirector = directorRepo.save(director);

        assertThat(savedDirector).isNotNull();
        assertThat(savedDirector.getName()).isEqualTo("John Doe");
        assertThat(savedDirector.getBirthDate()).isEqualTo(LocalDate.of(1990, 1, 1));
        assertThat(savedDirector.getPicture()).isEqualTo("picture_url");
        assertThat(savedDirector.getMovieIDs()).containsExactly("1", "2", "3");
        assertThat(savedDirector.getCountryID()).isEqualTo("country_id");
    }
}