package com.online_booking_ticket.movie_online_booking_ticket.entities;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
}
