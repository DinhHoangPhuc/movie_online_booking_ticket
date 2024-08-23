package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment {

    public Payment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentid")
    private int paymentId;

    @OneToOne
    @JoinColumn(name = "bookingid", referencedColumnName = "bookingid")
    @JsonManagedReference
    private Booking booking;

    @Column(name = "paymentdate")
    private Date paymentDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "paymentmethod")
    private String paymentMethod;
}
