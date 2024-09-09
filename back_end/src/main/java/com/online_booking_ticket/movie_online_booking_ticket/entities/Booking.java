package com.online_booking_ticket.movie_online_booking_ticket.entities;

import java.util.Date;

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
@Document("Bookings")
public class Booking {

    @Id
    private int id;

    private Date BookingDate;
    private int TotalAmount;
    private int UserID;
    private int ShowtimeID;
    private int SeatID;
//    private int PaymentID;
}
