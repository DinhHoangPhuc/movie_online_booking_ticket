package com.online_booking_ticket.movie_online_booking_ticket.services;

import com.online_booking_ticket.movie_online_booking_ticket.dto.GenreRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.GenreResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Genre;
import com.online_booking_ticket.movie_online_booking_ticket.mapper.GenreGenreResponseMapper;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.GenreRepo;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class GenreService {

    @Autowired
    GenreRepo genreRepo;

    @Autowired
    GenreGenreResponseMapper genreGenreResponseMapper;

    public GenreResponse addGenre(GenreRequest genreRequest) {
        Genre genre = genreGenreResponseMapper.genreRequestToGenre(genreRequest);
        return genreGenreResponseMapper.genreToGenreResponse(genreRepo.save(genre));
    }

    public List<GenreResponse> getGenres() {
        List<Genre> genres = genreRepo.findAll();
        List<GenreResponse> genreResponses = new ArrayList<>();

        for (Genre genre : genres) {
            genreResponses.add(genreGenreResponseMapper.genreToGenreResponse(genre));
        }

        return genreResponses;
    }
}
