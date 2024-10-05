package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.online_booking_ticket.movie_online_booking_ticket.entities.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    @Query("{'Email':?0}")
    Optional<User> findItemByEmail(String Email);

    @Query("{'PhoneNumber':?0}")
    Optional<User> findItemByPhoneNumber(String value);
}
