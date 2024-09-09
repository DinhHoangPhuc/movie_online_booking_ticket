package com.online_booking_ticket.movie_online_booking_ticket.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("Seats")
public class Seat {

    @Id
    private int id;

    private int RowNumber;

    @Field("ColumnNumber")
    private int SeatNumber;

    private int price;

    private String status;

    private int ScreenID;

//    @JsonBackReference
//    private Booking booking;
}
