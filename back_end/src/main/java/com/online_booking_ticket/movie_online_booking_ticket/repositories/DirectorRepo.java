package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Director;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;

@Repository
public interface DirectorRepo{

//    @Query("SELECT m FROM Movie m WHERE m.director.id = :directorId")
//    List<Movie> getMoviesByDirectorId(@Param("directorId") int directorId);
    // @Query("SELECT m FROM Movie m JOIN m.director d WHERE d.id = :directorId")
    // public List<Movie> findByDirectorId(int directorId);
}
