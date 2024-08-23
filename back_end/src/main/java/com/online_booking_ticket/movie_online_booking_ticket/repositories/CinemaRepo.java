package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Cinema;

public interface CinemaRepo extends JpaRepository<Cinema, Integer>{

    @Query("SELECT c FROM Cinema c JOIN c.screens s WHERE s.id = :screenId")
    Cinema findByScreenId(@Param("screenId") int screenId);

}
