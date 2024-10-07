package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.ActorRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.ActorResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Actor;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface ActorMapper {

    @Mapping(target = "movieIDs", ignore = true)
    Actor actorRequestToActor(ActorRequest actorRequest);
    ActorResponse actorToActorResponse(Actor actor);

    @AfterMapping
    default void setMovieIDs(@MappingTarget Actor actor) {
        actor.setMovieIDs(new ArrayList<>());
    }
}
