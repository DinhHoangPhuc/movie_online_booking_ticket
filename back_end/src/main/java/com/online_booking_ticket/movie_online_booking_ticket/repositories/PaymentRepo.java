package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
