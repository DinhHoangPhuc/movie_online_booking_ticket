package com.online_booking_ticket.movie_online_booking_ticket.services;

import java.util.Optional;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Payment;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.BookingRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online_booking_ticket.movie_online_booking_ticket.dto.PaymentRequest;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Booking;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private BookingRepo bookingRepo;

    public ResponseEntity<Payment> makePayment(PaymentRequest payment) {
        try {
            Payment paymentEntity = new Payment();

            Optional<Booking> booking = bookingRepo.findById(payment.getBookingId());
            if (!booking.isPresent()) {
                return ResponseEntity.badRequest().build();
            }

            paymentEntity.setBooking(booking.get());
            paymentEntity.setPaymentDate(payment.getPaymentDate());
            paymentEntity.setAmount(payment.getAmount());
            paymentEntity.setPaymentMethod(payment.getPaymentMethod());
            // paymentRepo.save(paymentEntity);
            return ResponseEntity.ok(paymentRepo.save(paymentEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
