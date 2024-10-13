package com.online_booking_ticket.movie_online_booking_ticket.execptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ShowtimeConflictExceptionHandler {

    @ExceptionHandler(ShowtimeConflictException.class)
    public ResponseEntity<?> handleShowtimeConflictException(ShowtimeConflictException e) {
        Map<String, String> response = Map.of("error", e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
