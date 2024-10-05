package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.DirectorRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.DirectorResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Director;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    Director directorRequestToDirector(DirectorRequest directorRequest);
    DirectorResponse directorToDirectorResponse(Director director);
}
