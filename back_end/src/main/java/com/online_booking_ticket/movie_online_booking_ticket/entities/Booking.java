package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Bookings")
public class Booking {

    @Id
    private String id;

    private LocalDate BookingDate;

    private int TotalAmount;

    private String UserID;

    private String ShowtimeID;

    private ArrayList<String> SeatIDs;
//    private int PaymentID;
}
