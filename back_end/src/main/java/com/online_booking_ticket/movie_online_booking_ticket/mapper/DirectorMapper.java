package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.DirectorRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.DirectorResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Director;
import org.mapstruct.*;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface DirectorMapper {

    @Mapping(target = "movieIDs", ignore = true)
    Director directorRequestToDirector(DirectorRequest directorRequest);
    DirectorResponse directorToDirectorResponse(Director director);

    @AfterMapping
    default void setMovieIDs(@MappingTarget Director director) {
        director.setMovieIDs(new ArrayList<>());
    }
}
