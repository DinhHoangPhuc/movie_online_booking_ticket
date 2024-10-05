package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class RegisterResponseDTO {
    private String name;
    private String email;
    private LocalDate dateOfBirth;
}
