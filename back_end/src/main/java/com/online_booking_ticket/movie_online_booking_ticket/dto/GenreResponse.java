package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class GenreResponse {
    String id;
    String Name;
    ArrayList<String> MovieIDs;
}
