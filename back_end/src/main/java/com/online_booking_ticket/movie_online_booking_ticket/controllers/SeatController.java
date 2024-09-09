package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import com.online_booking_ticket.movie_online_booking_ticket.dto.SetSeatRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.SetSeatResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SeatController {

    @MessageMapping("/seats")
    @SendTo("/topic/seats")
    public SetSeatResponse setSeat(@Payload SetSeatRequest setSeatRequest) {
        System.out.println("Seat " + setSeatRequest.getSeatId() + " is set");
        return new SetSeatResponse(setSeatRequest.getEmail(), setSeatRequest.getSeatId());
    }

    @MessageMapping("/unSetSeats")
    @SendTo("/topic/unSetSeats")
    public SetSeatResponse unSetSeat(@Payload SetSeatRequest setSeatRequest) {
        System.out.println("Seat " + setSeatRequest.getSeatId() + " is unset");
        return new SetSeatResponse(setSeatRequest.getEmail(), setSeatRequest.getSeatId());
    }
}
