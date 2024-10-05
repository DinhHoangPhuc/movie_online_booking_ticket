package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.ActorRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.ActorResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Actor;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ActorMapperTest {

    private final ActorMapper actorMapper = Mappers.getMapper(ActorMapper.class);

    @Test
    void actorRequestToActor() {
        ActorRequest actorRequest = new ActorRequest();
        actorRequest.setName("John Doe");
        actorRequest.setBirthDate(LocalDate.of(1990, 1, 1));
        actorRequest.setPicture("picture_url");
        actorRequest.setCountryID("country_id");

        Actor actor = actorMapper.actorRequestToActor(actorRequest);

        assertThat(actor).isNotNull();
        assertThat(actor.getName()).isEqualTo("John Doe");
        assertThat(actor.getBirthDate()).isEqualTo(LocalDate.of(1990, 1, 1));
        assertThat(actor.getPicture()).isEqualTo("picture_url");
        assertThat(actor.getCountryID()).isEqualTo("country_id");
    }

    @Test
    void actorToActorResponse() {
        Actor actor = new Actor();
        actor.setId("actor_id");
        actor.setName("John Doe");
        actor.setBirthDate(LocalDate.of(1990, 1, 1));
        actor.setPicture("picture_url");
        actor.setMovieIDs(new ArrayList<>());
        actor.setCountryID("country_id");

        ActorResponse actorResponse = actorMapper.actorToActorResponse(actor);

        assertThat(actorResponse).isNotNull();
        assertThat(actorResponse.getId()).isEqualTo("actor_id");
        assertThat(actorResponse.getName()).isEqualTo("John Doe");
        assertThat(actorResponse.getBirthDate()).isEqualTo(LocalDate.of(1990, 1, 1));
        assertThat(actorResponse.getPicture()).isEqualTo("picture_url");
        assertThat(actorResponse.getMovieIDs()).isEmpty();
        assertThat(actorResponse.getCountryID()).isEqualTo("country_id");
    }
}