package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Director;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer>{
    
    // @Query("SELECT DISTINCT m FROM Movie m JOIN m.showTimes st WHERE st.startTime IS NOT NULL")
    // Page<Movie> findAllWithShowTimes(Pageable pageable);

    @Query("SELECT DISTINCT m FROM Movie m JOIN m.showTimes st WHERE st.startTime IS NOT NULL")
    List<Movie> findAllWithShowTimes();

    @Query("SELECT m FROM Movie m WHERE m.showTimes IS EMPTY")
    List<Movie> findAllWithoutShowtimes();

    @Query("SELECT d FROM Director d JOIN d.movies m WHERE m.id = :movieId")
    Director findDirectorByMovieId(@Param("movieId") int movieId);
}
