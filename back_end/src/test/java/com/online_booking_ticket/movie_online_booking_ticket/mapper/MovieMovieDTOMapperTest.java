package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.MovieDTO;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieMovieDTOMapperTest {
     final MovieMovieDTOMapper movieMovieDTOMapper = Mappers.getMapper(MovieMovieDTOMapper.class);

    @Test
    void movieToMovieDTO() {
        // Given
        Movie movie = new Movie();
        movie.setPosterURL("https://example.org/example");
        movie.setReleaseDate(LocalDate.ofEpochDay(1L));
        movie.setDuration(1);
        movie.setGenreID("GenreID");
        movie.setCountryID("CountryID");
        movie.setTrailerURL("https://example.org/example");
        movie.setDirectorID("DirectorID");
        movie.setId("42");
        movie.setTitle("Title");
        movie.setDescription("The characteristics of someone or something");
        movie.setActorIDs(new ArrayList<String>());

        // When
        MovieDTO movieDTO = movieMovieDTOMapper.movieToMovieDTO(movie);

        // Then
        assertEquals("42", movieDTO.getId());
        assertEquals("Title", movieDTO.getTitle());
        assertEquals(1, movieDTO.getDuration());
        assertEquals(LocalDate.ofEpochDay(1L), movieDTO.getReleaseDate());
        assertEquals("The characteristics of someone or something", movieDTO.getDescription());
        assertEquals("https://example.org/example", movieDTO.getPosterURL());
        assertEquals("https://example.org/example", movieDTO.getTrailerURL());
        assertEquals("DirectorID", movieDTO.getDirectorID());
        assertEquals(new ArrayList<String>(), movieDTO.getActorIDs());
        assertEquals("CountryID", movieDTO.getCountryID());
        assertEquals("GenreID", movieDTO.getGenreID());
    }
}
