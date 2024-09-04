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
@Document("Showtimes")
public class Showtime {

    @Id
    private int id;

    private int MovieID;

    private int ScreenID;

    private List<Integer> Bookings;

    private Date StartTime;

    private Date EndTime;
}
