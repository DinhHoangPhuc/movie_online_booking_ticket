package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetSeatRequest {
    private String email;
    private int seatId;
}
