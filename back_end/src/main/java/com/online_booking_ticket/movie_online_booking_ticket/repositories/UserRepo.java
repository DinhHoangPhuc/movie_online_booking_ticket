package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online_booking_ticket.movie_online_booking_ticket.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

    Optional<User> findByEmail(String email);

    Optional<User> findByPhoneNumber(String value);
}
