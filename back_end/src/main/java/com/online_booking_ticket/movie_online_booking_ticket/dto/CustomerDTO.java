package com.online_booking_ticket.movie_online_booking_ticket.dto;


import com.online_booking_ticket.movie_online_booking_ticket.entities.Address;
import lombok.Data;

@Data
public class CustomerDTO {
    private String name;
    private Address address;
}
