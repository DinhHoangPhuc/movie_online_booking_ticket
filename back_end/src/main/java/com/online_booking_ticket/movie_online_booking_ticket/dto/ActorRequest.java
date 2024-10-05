package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActorRequest {
    private String Name;

    private LocalDate BirthDate;

    private String Picture;

    private String CountryID;
}
