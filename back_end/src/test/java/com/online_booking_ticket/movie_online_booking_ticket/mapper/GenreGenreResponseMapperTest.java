package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.GenreRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.GenreResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Genre;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class GenreGenreResponseMapperTest {


    private final GenreGenreResponseMapper genreGenreResponseMapper = Mappers.getMapper(GenreGenreResponseMapper.class);

    @Test
    public void testGenreToGenreResponse() {
        Genre genre = new Genre();
        genre.setName("Action");

        GenreResponse genreResponse = genreGenreResponseMapper.genreToGenreResponse(genre);

        assert genreResponse.getName().equals("Action");
    }

    @Test
    public void testGenreRequestToGenre() {
        GenreRequest genreRequest = new GenreRequest();
        genreRequest.setName("Action");

        Genre genre = genreGenreResponseMapper.genreRequestToGenre(genreRequest);

        assert genre.getName().equals("Action");
    }
}
