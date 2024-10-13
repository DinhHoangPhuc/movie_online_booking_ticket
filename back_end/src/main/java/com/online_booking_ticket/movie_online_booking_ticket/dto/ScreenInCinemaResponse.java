package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScreenInCinemaResponse {
    private String id;
    private int screenNumber;
}
