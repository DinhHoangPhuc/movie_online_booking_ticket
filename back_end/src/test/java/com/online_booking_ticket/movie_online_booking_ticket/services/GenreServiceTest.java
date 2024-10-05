package com.online_booking_ticket.movie_online_booking_ticket.services;

import com.online_booking_ticket.movie_online_booking_ticket.dto.GenreRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.GenreResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Genre;
import com.online_booking_ticket.movie_online_booking_ticket.mapper.GenreGenreResponseMapper;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.GenreRepo;
import com.online_booking_ticket.movie_online_booking_ticket.services.GenreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class GenreServiceTest {

    @Mock
    private GenreRepo genreRepo;

    @Mock
    private GenreGenreResponseMapper genreGenreResponseMapper;

    @InjectMocks
    private GenreService genreService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddGenre() {
        GenreRequest genreRequest = new GenreRequest();
        genreRequest.setName("Action");

        Genre genre = new Genre();
        genre.setName("Action");

        GenreResponse genreResponse = new GenreResponse();
        genreResponse.setName("Action");

        when(genreGenreResponseMapper.genreRequestToGenre(any(GenreRequest.class))).thenReturn(genre);
        when(genreRepo.save(any(Genre.class))).thenReturn(genre);
        when(genreGenreResponseMapper.genreToGenreResponse(any(Genre.class))).thenReturn(genreResponse);

        GenreResponse result = genreService.addGenre(genreRequest);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Action");
    }
}
