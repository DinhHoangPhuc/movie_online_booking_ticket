package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private int paymentId;

    @JsonManagedReference
    private Booking booking;

    private Date paymentDate;

    private BigDecimal amount;

    private String paymentMethod;
}
