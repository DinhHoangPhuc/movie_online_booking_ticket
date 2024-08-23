package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Screens")
@Getter
@Setter
public class Screen {

    public Screen() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScreenID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "CinemaID")
    @JsonBackReference
    private Cinema cinema;

    @Column(name = "Screennumber")
    private int screenNumber;

    @Column(name = "Totalrows")
    private int totalRows;

    @Column(name = "Totalcolumns")
    private int totalColumns;

    @OneToMany(mappedBy = "screen")
    @JsonManagedReference
    private List<Showtime> showTimes;

    @OneToMany(mappedBy = "screen")
    @JsonManagedReference
    private List<Seat> seats;
}
