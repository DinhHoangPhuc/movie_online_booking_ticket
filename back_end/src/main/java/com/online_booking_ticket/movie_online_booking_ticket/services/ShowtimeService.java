package com.online_booking_ticket.movie_online_booking_ticket.services;

import java.util.List;

import com.online_booking_ticket.movie_online_booking_ticket.repositories.CinemaRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.ScreenRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.ShowtimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Cinema;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Screen;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Seat;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Showtime;

@Service
public class ShowtimeService{
    @Autowired
    private ShowtimeRepo showtimeRepository;

    @Autowired
    private ScreenRepo screenRepo;

    @Autowired
    private CinemaRepo cinemaRepo;

    // public ResponseEntity<Showtime> findCinemasByShowtime(int showtimeId) {
    //     try {
    //         Showtime showtime = showtimeRepository.findById(showtimeId).get();
    //         // Screen screen = screenRepo.findById(showtime.getScreen().getId()).get();
    //         // Cinema cinema = cinemaRepo.findById(screen.getCinema().getId()).get();
    //         return new ResponseEntity<>(showtime, HttpStatus.OK);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }

    public ResponseEntity<Cinema> findCinemasByShowtime(int showtimeId) {
        try {
            Showtime showtime = showtimeRepository.findById(showtimeId).get();
            Screen screen = screenRepo.findById(showtime.getScreen().getId()).get();
            Cinema cinema = cinemaRepo.findById(screen.getCinema().getId()).get();
            return new ResponseEntity<>(cinema, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Showtime>> getShowtimes() {
        try {
            return new ResponseEntity<>(showtimeRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Seat>> findSeatsByShowtime(int showtimeid) {
        try {
            Showtime showtime = showtimeRepository.findById(showtimeid).get();
            Screen screen = screenRepo.findById(showtime.getScreen().getId()).get();
            List<Seat> seats = screen.getSeats();
            return new ResponseEntity<>(seats, HttpStatus.OK);

            // return new ResponseEntity<>(showtimeRepository.findSeatsByShowtimeId(showtimeid), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Screen> findScreenByShowtime(int showtimeId) {
        try {
            Showtime showtime = showtimeRepository.findById(showtimeId).get();
            Screen screen = screenRepo.findById(showtime.getScreen().getId()).get();
            return new ResponseEntity<>(screen, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//     public ResponseEntity<String> getCinemaByShowtimeId(int showtimeid) {
//         try {
//             String sql = "SELECT c.Name FROM Cinemas c " +
//                      "JOIN Screens s ON c.CinemaID = s.CinemaID " +
//                      "JOIN Showtimes st ON s.ScreenID = st.ScreenID " +
//                      "WHERE st.ShowtimeID = ?";

//             Connection conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-CUA-PHUC\\\\SQLEXPRESS:1433;databaseName=DatVeXemPhim;encrypt=false;trustServerCertificate=false;hostNameInCertificate=LAPTOP-CUA-PHUC\\\\SQLEXPRESS");

//             PreparedStatement ps = conn.prepareStatement(sql);
//             ps.setInt(1, showtimeid);

//             ResultSet rs = ps.executeQuery();

//             if (rs.next()) {
//                 String cinemaName = rs.getString("Name");
//                 return ResponseEntity.ok(cinemaName);
//             } else {
//                 return ResponseEntity.notFound().build();
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//             return ResponseEntity.notFound().build();
//         }
//     }
}
