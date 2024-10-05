//package com.online_booking_ticket.movie_online_booking_ticket.services;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.online_booking_ticket.movie_online_booking_ticket.dto.BookingInShowtimes;
//import com.online_booking_ticket.movie_online_booking_ticket.dto.CinemaByShowtimeId;
//import com.online_booking_ticket.movie_online_booking_ticket.dto.ScreenByShowtime;
//import com.online_booking_ticket.movie_online_booking_ticket.dto.ShowtimeInScreenByShowtime;
//import com.online_booking_ticket.movie_online_booking_ticket.entities.*;
//import com.online_booking_ticket.movie_online_booking_ticket.repositories.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ShowtimeService{
//    @Autowired
//    private ShowtimeRepo showtimeRepository;
//
//    @Autowired
//    private ScreenRepo screenRepo;
//
//    @Autowired
//    private SeatRepo seatRepo;
//
//    @Autowired
//    private CinemaRepo cinemaRepo;
//
//    @Autowired
//    private BookingRepo bookingRepo;
//
//    // public ResponseEntity<Showtime> findCinemasByShowtime(int showtimeId) {
//    //     try {
//    //         Showtime showtime = showtimeRepository.findById(showtimeId).get();
//    //         // Screen screen = screenRepo.findById(showtime.getScreen().getId()).get();
//    //         // Cinema cinema = cinemaRepo.findById(screen.getCinema().getId()).get();
//    //         return new ResponseEntity<>(showtime, HttpStatus.OK);
//    //     } catch (Exception e) {
//    //         e.printStackTrace();
//    //         return null;
//    //     }
//    // }
//
//    public ResponseEntity<CinemaByShowtimeId> findCinemasByShowtime(int showtimeId) {
//        try {
//            Showtime showtime = showtimeRepository.findById(showtimeId).get();
//            Screen screen = screenRepo.findById(showtime.getScreenID()).get();
//            Cinema cinema = cinemaRepo.findById(screen.getCinemaID()).get();
//            CinemaByShowtimeId cinemaByShowtimeId = new CinemaByShowtimeId(cinema, showtime.getStartTime());
//            return new ResponseEntity<>(cinemaByShowtimeId, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    public ResponseEntity<List<Showtime>> getShowtimes() {
//        try {
//            return new ResponseEntity<>(showtimeRepository.findAll(), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    public ResponseEntity<List<Seat>> findSeatsByShowtime(int showtimeid) {
//        try {
//            Showtime showtime = showtimeRepository.findById(showtimeid).get();
//            Screen screen = screenRepo.findById(showtime.getScreenID()).get();
//            List<Integer> seatIds = screen.getSeats();
//            List<Seat> seats = new ArrayList<>();
//            seatIds.forEach(seatId -> {
//                Seat seat = seatRepo.findById(seatId).orElse(null);
//                seats.add(seat);
//            });
////            List<Seat> seats = screen.getSeats();
//            return new ResponseEntity<>(seats, HttpStatus.OK);
//
//            // return new ResponseEntity<>(showtimeRepository.findSeatsByShowtimeId(showtimeid), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    public ResponseEntity<ScreenByShowtime> findScreenByShowtime(int showtimeId) {
//        try {
//            Showtime showtime = showtimeRepository.findById(showtimeId).get();
//            Screen screen = screenRepo.findById(showtime.getScreenID()).get();
//
//            ScreenByShowtime screenByShowtime = new ScreenByShowtime();
//            screenByShowtime.setId(screen.getId());
//            screenByShowtime.setScreenNumber(screen.getScreenNumber());
//            screenByShowtime.setTotalRows(screen.getTotalRows());
//            screenByShowtime.setTotalColumns(screen.getTotalColumns());
//
//            List<ShowtimeInScreenByShowtime> showtimes = new ArrayList<>();
//            screen.getShowtimes().forEach(showtimeIdInScreen -> {
//                Showtime showtimeInScreen = showtimeRepository.findById(showtimeIdInScreen).get();
//                ShowtimeInScreenByShowtime showtimeInScreenByShowtime = new ShowtimeInScreenByShowtime();
//                showtimeInScreenByShowtime.setId(showtimeInScreen.getId());
//                List<BookingInShowtimes> bookings = new ArrayList<>();
//                showtimeInScreen.getBookings().forEach(booking -> {
//                    Booking bookingInShowtime = bookingRepo.findById(booking).get();
//                    BookingInShowtimes bookingInShowtimes = new BookingInShowtimes();
//                    bookingInShowtimes.setId(bookingInShowtime.getId());
//                    bookingInShowtimes.setBookingDate(bookingInShowtime.getBookingDate());
//                    bookingInShowtimes.setTotalAmount(bookingInShowtime.getTotalAmount());
//                    bookingInShowtimes.setSeat(seatRepo.findById(bookingInShowtime.getSeatID()).get());
//                    bookings.add(bookingInShowtimes);
//                });
//                showtimeInScreenByShowtime.setBookings(bookings);
//                showtimeInScreenByShowtime.setStartTime(showtimeInScreen.getStartTime());
//                showtimeInScreenByShowtime.setEndTime(showtimeInScreen.getEndTime());
//                showtimes.add(showtimeInScreenByShowtime);
//            });
//            screenByShowtime.setShowtimes(showtimes);
//
//            List<Seat> seats = new ArrayList<>();
//            screen.getSeats().forEach(seatId -> {
//                Seat seat = seatRepo.findById(seatId).get();
//                seats.add(seat);
//            });
//            screenByShowtime.setSeats(seats);
//
//            return new ResponseEntity<>(screenByShowtime, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
////     public ResponseEntity<String> getCinemaByShowtimeId(int showtimeid) {
////         try {
////             String sql = "SELECT c.Name FROM Cinemas c " +
////                      "JOIN Screens s ON c.CinemaID = s.CinemaID " +
////                      "JOIN Showtimes st ON s.ScreenID = st.ScreenID " +
////                      "WHERE st.ShowtimeID = ?";
//
////             Connection conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-CUA-PHUC\\\\SQLEXPRESS:1433;databaseName=DatVeXemPhim;encrypt=false;trustServerCertificate=false;hostNameInCertificate=LAPTOP-CUA-PHUC\\\\SQLEXPRESS");
//
////             PreparedStatement ps = conn.prepareStatement(sql);
////             ps.setInt(1, showtimeid);
//
////             ResultSet rs = ps.executeQuery();
//
////             if (rs.next()) {
////                 String cinemaName = rs.getString("Name");
////                 return ResponseEntity.ok(cinemaName);
////             } else {
////                 return ResponseEntity.notFound().build();
////             }
////         } catch (Exception e) {
////             e.printStackTrace();
////             return ResponseEntity.notFound().build();
////         }
////     }
//}
