package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.GenreRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.GenreResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Genre;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface GenreGenreResponseMapper {
    GenreResponse genreToGenreResponse(Genre genre);

    @Mapping(target = "movieIDs", ignore = true)
    Genre genreRequestToGenre(GenreRequest genreRequest);

    @AfterMapping
    default void setMovieIDs(@MappingTarget Genre genre) {
        genre.setMovieIDs(new ArrayList<>());
    }
}
