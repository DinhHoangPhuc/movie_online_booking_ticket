package com.online_booking_ticket.movie_online_booking_ticket.execptionHandler;

public class InvalidShowtimeDateException extends RuntimeException {
    public InvalidShowtimeDateException(String message) {
        super(message);
    }
}
