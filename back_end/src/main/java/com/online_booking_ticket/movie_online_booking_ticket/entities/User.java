package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.Date;
import java.util.List;

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
@Document("Users")
public class User {

    @Id
    private int id;

    private String Name;

    private String Email;

    private String Password;

    private String PhoneNumber;

    private Date DateOfBirth;

//    @JsonManagedReference
//    private List<Booking> bookings;

    private List<Integer> Authorities;
}
