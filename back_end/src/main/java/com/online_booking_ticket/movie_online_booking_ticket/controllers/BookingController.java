package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import com.online_booking_ticket.movie_online_booking_ticket.dto.TicketInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online_booking_ticket.movie_online_booking_ticket.dto.BookingRequest;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Booking;
import com.online_booking_ticket.movie_online_booking_ticket.services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;
    
    @PostMapping("/bookings")
    public ResponseEntity<TicketInformation> createBooking(@RequestBody BookingRequest bookingRequest, Authentication authentication) {
        TicketInformation ticketInformation = bookingService.createTicket(bookingRequest, authentication.getName());
        if (ticketInformation != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(ticketInformation);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/bookings/history")
    public ResponseEntity<List<TicketInformation>> bookingHistory(Authentication authentication) {
        List<TicketInformation> ticketInformation = bookingService.getBookingHistory(authentication.getName());
        if (ticketInformation != null) {
            return ResponseEntity.ok(ticketInformation);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
