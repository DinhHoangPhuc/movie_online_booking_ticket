//package com.online_booking_ticket.movie_online_booking_ticket.services;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//import com.online_booking_ticket.movie_online_booking_ticket.dto.TicketInformation;
//import com.online_booking_ticket.movie_online_booking_ticket.entities.User;
//import com.online_booking_ticket.movie_online_booking_ticket.repositories.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.online_booking_ticket.movie_online_booking_ticket.dto.BookingRequest;
//import com.online_booking_ticket.movie_online_booking_ticket.entities.Booking;
//
//@Service
//public class BookingService {
//
//    @Autowired
//    private BookingRepo bookingRepo;
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Autowired
//    private ShowtimeRepo showtimeRepo;
//
//    @Autowired
//    private SeatRepo seatRepo;
//
//    @Autowired
//    private MovieRepo movieRepo;
//
//    @Autowired
//    private CinemaRepo cinemaRepo;
//
//    @Autowired
//    private ScreenRepo screenRepo;
//
//    public List<TicketInformation> getBookingHistory(String email) {
//        List<Booking> booking = getBookingByUser(email);
//        return booking == null ? null : booking.stream().map(this::createTicketInformation).toList();
//    }
//
//    public List<Booking> getBookingByUser(String email) {
//        User user = userRepo.findItemByEmail(email).orElse(null);
//        if (user == null) {
//            return null;
//        }
//        return bookingRepo.findItemByUserID(user.getId()).orElse(null);
//    }
//
//    public TicketInformation createTicket(BookingRequest bookingRequest, String email) {
//        Booking booking = createBooking(bookingRequest, email);
//        return booking == null ? null : createTicketInformation(booking);
//    }
//
//    public Booking createBooking(BookingRequest bookingRequest, String email) {
//        try {
//            Booking booking = new Booking();
//            booking.setUserID(Objects.requireNonNull(userRepo.findItemByEmail(email).orElse(null)).getId());
//            booking.setShowtimeID(Objects.requireNonNull(showtimeRepo.findById(bookingRequest.getShowtimeId()).orElse(null)).getId());
//            booking.setSeatID(Objects.requireNonNull(seatRepo.findById(bookingRequest.getSeatId()).orElse(null)).getId());
//            booking.setBookingDate(new Date());
//            booking.setTotalAmount(bookingRequest.getTotalAmount());
//            return bookingRepo.save(booking);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public TicketInformation createTicketInformation(Booking booking) {
////        TicketInformation ticketInformation = new TicketInformation();
////        ticketInformation.setTicketId(booking.getId());
////        ticketInformation.setMovieName(booking.getShowtime().getMovie().getTitle());
////        ticketInformation.setCinemaName(booking.getShowtime().getScreen().getCinema().getName());
////        ticketInformation.setScreenNumber(booking.getShowtime().getScreen().getId());
////        ticketInformation.setSeatNumber(booking.getSeat().getId());
////        ticketInformation.setStartTime(booking.getShowtime().getStartTime());
////        ticketInformation.setEndTime(booking.getShowtime().getEndTime());
////        ticketInformation.setTotalAmount(booking.getTotalAmount());
////        ticketInformation.setBookingDate(booking.getBookingDate());
////        ticketInformation.setUserName(booking.getUser().getName());
////        return ticketInformation;
//        return createTicketInformationInstance(booking);
//    }
//
//    private TicketInformation createTicketInformationInstance(Booking booking) {
//        TicketInformation ticketInformation = new TicketInformation();
//        ticketInformation.setTicketId(booking.getId());
//        movieRepo.findById(showtimeRepo.findById(booking.getShowtimeID()).get().getMovieID()).ifPresent(movie -> ticketInformation.setMovieName(movie.getTitle()));
////        ticketInformation.setMovieName(booking.getShowtime().getMovie().getTitle());
//        cinemaRepo.findById(showtimeRepo.findById(booking.getShowtimeID()).get().getScreenID()).ifPresent(cinema -> ticketInformation.setCinemaName(cinema.getName()));
////        ticketInformation.setCinemaName(booking.getShowtime().getScreen().getCinema().getName());
//        screenRepo.findById(showtimeRepo.findById(booking.getShowtimeID()).get().getScreenID()).ifPresent(screen -> ticketInformation.setScreenNumber(screen.getId()));
////        ticketInformation.setScreenNumber(booking.getShowtime().getScreen().getId());
//        seatRepo.findById(booking.getSeatID()).ifPresent(seat -> ticketInformation.setSeatNumber(seat.getId()));
////        ticketInformation.setSeatNumber(booking.getSeat().getId());
//        showtimeRepo.findById(booking.getShowtimeID()).ifPresent(showtime -> {
//            ticketInformation.setStartTime(showtime.getStartTime());
//            ticketInformation.setEndTime(showtime.getEndTime());
//        });
////        ticketInformation.setStartTime(booking.getShowtime().getStartTime());
////        ticketInformation.setEndTime(booking.getShowtime().getEndTime());
//        bookingRepo.findById(booking.getId()).ifPresent(booking1 -> {
//            ticketInformation.setTotalAmount(booking1.getTotalAmount());
//            ticketInformation.setBookingDate(booking1.getBookingDate());
//        });
////        ticketInformation.setTotalAmount(booking.getTotalAmount());
////        ticketInformation.setBookingDate(booking.getBookingDate());
//        userRepo.findById(booking.getUserID()).ifPresent(user -> ticketInformation.setUserName(user.getName()));
////        ticketInformation.setUserName(booking.getUser().getName());
//        return ticketInformation;
//    }
//
//}
