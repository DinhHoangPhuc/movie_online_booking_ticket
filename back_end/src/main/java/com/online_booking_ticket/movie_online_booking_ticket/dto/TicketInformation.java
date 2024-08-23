package com.online_booking_ticket.movie_online_booking_ticket.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TicketInformation {
    private int ticketId;
    private String movieName;
    private String cinemaName;
    private int screenNumber;
    private int seatNumber;
    private Date startTime;
    private Date endTime;
    private double totalAmount;
    private Date bookingDate;
    private String userName;
}
