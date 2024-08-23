package com.online_booking_ticket.movie_online_booking_ticket.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.online_booking_ticket.movie_online_booking_ticket.dto.TicketInformation;
import com.online_booking_ticket.movie_online_booking_ticket.entities.User;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.BookingRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.SeatRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.ShowtimeRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online_booking_ticket.movie_online_booking_ticket.dto.BookingRequest;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Booking;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ShowtimeRepo showtimeRepo;

    @Autowired
    private SeatRepo seatRepo;

    public List<TicketInformation> getBookingHistory(String email) {
        List<Booking> booking = getBookingByUser(email);
        return booking == null ? null : booking.stream().map(this::createTicketInformation).toList();
    }

    public List<Booking> getBookingByUser(String email) {
        User user = userRepo.findByEmail(email).orElse(null);
        if (user == null) {
            return null;
        }
        return bookingRepo.findByUser(user).orElse(null);
    }

    public TicketInformation createTicket(BookingRequest bookingRequest, String email) {
        Booking booking = createBooking(bookingRequest, email);
        return booking == null ? null : createTicketInformation(booking);
    }

    public Booking createBooking(BookingRequest bookingRequest, String email) {
        try {
            Booking booking = new Booking();
            booking.setUser(userRepo.findByEmail(email).orElse(null));
            booking.setShowtime(showtimeRepo.findById(bookingRequest.getShowtimeId()).orElse(null));
            booking.setSeat(seatRepo.findById(bookingRequest.getSeatId()).orElse(null));
            booking.setBookingDate(new Date());
            booking.setTotalAmount(bookingRequest.getTotalAmount());
            return bookingRepo.save(booking);
        } catch (Exception e) {
            return null;
        }
    }

    public TicketInformation createTicketInformation(Booking booking) {
        TicketInformation ticketInformation = new TicketInformation();
        ticketInformation.setTicketId(booking.getId());
        ticketInformation.setMovieName(booking.getShowtime().getMovie().getTitle());
        ticketInformation.setCinemaName(booking.getShowtime().getScreen().getCinema().getName());
        ticketInformation.setScreenNumber(booking.getShowtime().getScreen().getId());
        ticketInformation.setSeatNumber(booking.getSeat().getId());
        ticketInformation.setStartTime(booking.getShowtime().getStartTime());
        ticketInformation.setEndTime(booking.getShowtime().getEndTime());
        ticketInformation.setTotalAmount(booking.getTotalAmount());
        ticketInformation.setBookingDate(booking.getBookingDate());
        ticketInformation.setUserName(booking.getUser().getName());
        return ticketInformation;
    }



}
