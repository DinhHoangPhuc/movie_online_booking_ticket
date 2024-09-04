package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("Payments")
public class Payment {

    @Id
    private int id;

    private Date PaymentDate;
    private BigDecimal Amount;
    private String PaymentMethod;
    private Booking booking;

}
