package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {

    public User() {
    }

    @Id
    @Column(name = "UserID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "dateofbirth")
    private Date dateOfBirth;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Booking> bookings;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities",
                joinColumns = @JoinColumn(name = "userid"),
                inverseJoinColumns = @JoinColumn(name = "authorityid"))
    private Set<Authority> authorities;
}
