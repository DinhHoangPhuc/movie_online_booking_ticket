package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.online_booking_ticket.movie_online_booking_ticket.dto.PaymentRequest;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Payment;
import com.online_booking_ticket.movie_online_booking_ticket.services.PaymentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<Payment> makePayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.makePayment(paymentRequest);
    }
}
