package com.online_booking_ticket.movie_online_booking_ticket.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "Seats")
@Getter
@Setter
public class Seat {

    public Seat() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SeatID")
    private int id;

    @Column(name = "Rownumber")
    private int rowNumber;

    @Column(name = "Columnnumber ")
    private int seatNumber;

    @Column(name = "price")
    private int price;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "ScreenID")
    @JsonBackReference
    private Screen screen;

    @OneToOne(mappedBy = "seat")
    @JsonBackReference
    private Booking booking;
}
