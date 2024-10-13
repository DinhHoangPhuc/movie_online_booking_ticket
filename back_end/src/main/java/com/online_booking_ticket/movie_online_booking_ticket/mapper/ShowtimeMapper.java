package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.CinemaInShowtimeResponse;
import com.online_booking_ticket.movie_online_booking_ticket.dto.MovieInShowtimeResponse;
import com.online_booking_ticket.movie_online_booking_ticket.dto.ShowTimeRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.ShowTimeResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Cinema;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Screen;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Showtime;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.CinemaRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.MovieRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.ScreenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ShowtimeMapper {

    @Autowired
    private ScreenRepo screenRepo;

    @Autowired
    private CinemaRepo cinemaRepo;

    @Autowired
    private MovieRepo movieRepo;

    public Showtime mapRequestToEntity(ShowTimeRequest request) {
        Showtime showtime = new Showtime();
        showtime.setMovieID(request.getMovieID());
        showtime.setScreenID(request.getScreenID());
        showtime.setDate(LocalDate.parse(request.getDate()));
        showtime.setStartTime(LocalTime.parse(request.getStartTime()));
        showtime.setEndTime(LocalTime.parse(request.getEndTime()));
        return showtime;
    }

    public ShowTimeResponse mapEntityToResponse(Showtime showtime) {
        ShowTimeResponse response = new ShowTimeResponse();
        response.setId(showtime.getId());
        response.setDate(showtime.getDate());
        response.setStartTime(showtime.getStartTime());
        response.setEndTime(showtime.getEndTime());

        Screen screen = screenRepo.findById(showtime.getScreenID()).orElseThrow(() -> new RuntimeException("Screen not found"));
        Cinema cinema = cinemaRepo.findById(screen.getCinemaID()).orElseThrow(() -> new RuntimeException("Cinema not found"));

        response.setCineama(new CinemaInShowtimeResponse(cinema.getId(), cinema.getName(), screen.getId(), screen.getScreenNumber()));

        Movie movie = movieRepo.findById(showtime.getMovieID()).orElseThrow(() -> new RuntimeException("Movie not found"));

        response.setMovie(new MovieInShowtimeResponse(movie.getId(), movie.getTitle()));

        return response;
    }
}
