package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class GenreRequest {
    String Name;
}
