package com.online_booking_ticket.movie_online_booking_ticket.entities;

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
@Document("Cinemas")
public class Cinema {

    @Id
    private int id;

    private String Mame;

    private String Location;

    private String TotalScreens;

    private List<Integer> Screens;
}
