package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequestDTO {
    private String userName;
    private String password;
}
