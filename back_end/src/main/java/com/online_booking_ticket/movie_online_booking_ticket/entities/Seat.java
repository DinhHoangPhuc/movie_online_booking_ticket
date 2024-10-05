package com.online_booking_ticket.movie_online_booking_ticket.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("Seats")
public class Seat {

    @Id
    private String id;

    private int RowNumber;

    private int ColumnNumber;

    private int price;

    private String ScreenID;
}
