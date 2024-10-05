package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import java.util.List;

import com.online_booking_ticket.movie_online_booking_ticket.dto.MovieWithShowtime;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Director;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;

@Repository
public interface MovieRepo extends MongoRepository<Movie, String> {
    
//     @Query("SELECT DISTINCT m FROM Movie m JOIN m.showTimes st WHERE st.startTime IS NOT NULL")
//     Page<Movie> findAllWithShowTimes(Pageable pageable);

//    @Query("SELECT DISTINCT m FROM Movie m JOIN m.showTimes st WHERE st.startTime IS NOT NULL")
    @Aggregation(pipeline = {
            "{ '$lookup': { 'from': 'Showtimes', 'localField': '_id', 'foreignField': 'MovieID', 'as': 'Showtimes' } }",
            "{ '$match': { 'Showtimes': { '$ne': [] } } }"
    })
    List<MovieWithShowtime> findAllWithShowTimes();

//    @Query("SELECT m FROM Movie m WHERE m.showTimes IS EMPTY")
    @Aggregation(pipeline = {
            "{ '$lookup': { 'from': 'Showtimes', 'localField': '_id', 'foreignField': 'MovieID', 'as': 'Showtimes' } }",
            "{ '$match': { 'Showtimes': { '$eq': [] } } }"
    })
    List<MovieWithShowtime> findAllWithoutShowtimes();
//
//    @Query("SELECT d FROM Director d JOIN d.movies m WHERE m.id = :movieId")
//    Director findDirectorByMovieId(@Param("movieId") int movieId);
}
