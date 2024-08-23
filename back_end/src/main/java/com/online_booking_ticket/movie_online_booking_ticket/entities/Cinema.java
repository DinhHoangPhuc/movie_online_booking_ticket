package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Cinemas")
@Getter
@Setter
public class Cinema {

        public Cinema() {
        }
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CinemaID")
        private int id;
    
        @Column(name = "Name")
        private String name;
    
        @Column(name = "Location")
        private String location;
    
        @Column(name = "Totalscreens")
        private String totalScreens;
    
       @OneToMany(mappedBy = "cinema")
       @JsonManagedReference
        private List<Screen> screens;
    
        // getters and setters
}
