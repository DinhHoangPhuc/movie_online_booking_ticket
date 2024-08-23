package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class RegisterResponseDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
}
