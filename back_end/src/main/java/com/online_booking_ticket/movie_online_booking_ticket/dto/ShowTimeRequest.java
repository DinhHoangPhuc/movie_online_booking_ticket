package com.online_booking_ticket.movie_online_booking_ticket.dto;

import com.online_booking_ticket.movie_online_booking_ticket.customAnnotation.ValidShowtimeDate;
import com.online_booking_ticket.movie_online_booking_ticket.customAnnotation.ValidShowtimeTime;
import lombok.Data;

@Data
public class ShowTimeRequest {

        private String MovieID;

        private String ScreenID;

        @ValidShowtimeDate
        private String Date;

        @ValidShowtimeTime
        private String StartTime;

        private String EndTime;
}
