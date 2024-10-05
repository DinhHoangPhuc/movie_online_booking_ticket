package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import com.online_booking_ticket.movie_online_booking_ticket.config.MongoTestConfig;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Actor;
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
class ActorRepoTest {

    @Autowired
    private ActorRepo actorRepo;

    @BeforeEach
    public void setUp() {
        actorRepo.deleteAll();
    }

    @Test
    public void testSaveActor() {
        Actor actor = new Actor();
        actor.setName("John Doe");
        actor.setBirthDate(LocalDate.of(1990, 1, 1));
        actor.setPicture("picture_url");
        actor.setMovieIDs(new ArrayList<>(Arrays.asList("1", "2", "3")));
        actor.setCountryID("country_id");

        Actor savedActor = actorRepo.save(actor);

        assertThat(savedActor).isNotNull();
        assertThat(savedActor.getName()).isEqualTo("John Doe");
        assertThat(savedActor.getBirthDate()).isEqualTo(LocalDate.of(1990, 1, 1));
        assertThat(savedActor.getPicture()).isEqualTo("picture_url");
        assertThat(savedActor.getMovieIDs()).containsExactly("1", "2", "3");
        assertThat(savedActor.getCountryID()).isEqualTo("country_id");
    }
}