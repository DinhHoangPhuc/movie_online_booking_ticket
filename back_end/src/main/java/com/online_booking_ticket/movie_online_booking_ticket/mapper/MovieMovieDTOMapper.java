package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.MovieDTO;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MovieMovieDTOMapper {

    MovieDTO movieToMovieDTO(Movie movie);
}
