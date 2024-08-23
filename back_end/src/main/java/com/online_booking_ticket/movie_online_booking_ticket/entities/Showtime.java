package com.online_booking_ticket.movie_online_booking_ticket.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Showtimes")
@Getter
@Setter
public class Showtime {

    public Showtime() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShowtimeID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "MovieID")
    @JsonBackReference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "ScreenID")
    @JsonBackReference
    private Screen screen;

    @OneToMany(mappedBy = "showtime")
    @JsonManagedReference
    private List<Booking> bookings;

    @Column(name = "Starttime")
    private Date startTime;

    @Column(name = "Endtime")
    private Date endTime;
}
