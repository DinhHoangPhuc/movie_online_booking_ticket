package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.*;
import com.online_booking_ticket.movie_online_booking_ticket.entities.*;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.ActorRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.CountryRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.DirectorRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {

    @Autowired
    private DirectorRepo directorRepo;

    @Autowired
    private ActorRepo actorRepo;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private GenreRepo genreRepo;

    @Autowired
    private DirectorMapper directorMapper;

    @Autowired
    private ActorMapper actorMapper;

    @Autowired
    private CountryCountryRequestMapper countryMapper;

    @Autowired
    private GenreGenreResponseMapper genreMapper;

    public Movie movieRequestToMovie(MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setTitle(movieRequest.getTitle());
        movie.setDuration(movieRequest.getDuration());
        movie.setReleaseDate(movieRequest.getReleaseDate());
        movie.setDescription(movieRequest.getDescription());
        movie.setPosterURL(movieRequest.getPosterURL());
        movie.setTrailerURL(movieRequest.getTrailerURL());
        movie.setDirectorID(movieRequest.getDirectorID());
        movie.setActorIDs(movieRequest.getActorIDs());
        movie.setCountryID(movieRequest.getCountryID());
        movie.setGenreID(movieRequest.getGenreID());
        return movie;
    }

    public MovieResponse movieToMovieResponse(Movie movie){
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(movie.getId());
        movieResponse.setTitle(movie.getTitle());
        movieResponse.setDuration(movie.getDuration());
        movieResponse.setReleaseDate(movie.getReleaseDate());
        movieResponse.setDescription(movie.getDescription());
        movieResponse.setPosterURL(movie.getPosterURL());
        movieResponse.setTrailerURL(movie.getTrailerURL());
        Director director = mapDirector(movie.getDirectorID());
        movieResponse.setDirector(mapDirectorToResponse(director));
        movieResponse.setActors(mapActorsToResponse(mapActors(movie.getActorIDs())));
        movieResponse.setCountry(mapCountryToResponse(mapCountry(movie.getCountryID())));
        movieResponse.setGenre(mapGenreToResponse(mapGenre(movie.getGenreID())));
        return movieResponse;
    }

    Director mapDirector(String directorID) {
        return directorRepo.findById(directorID).orElse(null);
    }

    List<Actor> mapActors(List<String> actorIDs) {
        return actorIDs.stream()
                .map(id -> actorRepo.findById(id).orElse(null))
                .filter(actor -> actor != null) // Filter out null values
                .collect(Collectors.toList());
    }

    Country mapCountry(String countryID) {
        return countryRepo.findById(countryID).orElse(null);
    }

    Genre mapGenre(String genreID) {
        return genreRepo.findById(genreID).orElse(null);
    }

    DirectorResponse mapDirectorToResponse(Director director) {
        return director != null ? directorMapper.directorToDirectorResponse(director) : null;
    }

    List<ActorResponse> mapActorsToResponse(List<Actor> actors) {
        return actors.stream()
                .map(actor -> actor != null ? actorMapper.actorToActorResponse(actor) : null)
                .collect(Collectors.toList());
    }

    CountryResponse mapCountryToResponse(Country country) {
        return country != null ? countryMapper.countryToCountryResponse(country) : null;
    }

    GenreResponse mapGenreToResponse(Genre genre) {
        return genre != null ? genreMapper.genreToGenreResponse(genre) : null;
    }
}