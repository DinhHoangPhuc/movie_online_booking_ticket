package com.online_booking_ticket.movie_online_booking_ticket.entities;

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
@Document("Seats")
public class Seat {

    @Id
    private int id;

    private int RowNumber;

    private int SeatNumber;

    private int Price;

    private String Status;

    private int ScreenID;

//    @JsonBackReference
//    private Booking booking;
}
