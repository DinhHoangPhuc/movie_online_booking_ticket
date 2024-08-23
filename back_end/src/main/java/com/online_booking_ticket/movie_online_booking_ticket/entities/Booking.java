package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Bookings")
@Getter
@Setter
public class Booking {

    public Booking() {
    }

    @Id
    @Column(name = "BookingID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bookingdate")
    private Date bookingDate;

    @Column(name = "totalamount")
    private int totalAmount;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "showtimeid")
    @JsonBackReference
    private Showtime showtime;

    @OneToOne
    @JoinColumn(name = "seatid")
    @JsonManagedReference
    private Seat seat;

    @OneToOne(mappedBy = "booking")
    @JsonBackReference
    private Payment payment;
}
