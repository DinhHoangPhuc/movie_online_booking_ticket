package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority {


    private int id;


    private String name;


    private Set<User> users;
}
