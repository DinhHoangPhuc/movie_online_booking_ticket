package com.online_booking_ticket.movie_online_booking_ticket.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Customers")
@Data
public class Customer {

    @Id
    private String id;
    private String name;
    private Address address;
}
