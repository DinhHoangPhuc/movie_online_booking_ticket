package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.GenreRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.GenreResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreGenreResponseMapper {
    GenreResponse genreToGenreResponse(Genre genre);
    Genre genreRequestToGenre(GenreRequest genreRequest);
}
