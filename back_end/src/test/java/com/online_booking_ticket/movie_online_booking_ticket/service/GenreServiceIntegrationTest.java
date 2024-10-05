//package com.online_booking_ticket.movie_online_booking_ticket.service;
//
//import com.online_booking_ticket.movie_online_booking_ticket.dto.GenreRequest;
//import com.online_booking_ticket.movie_online_booking_ticket.dto.GenreResponse;
//import com.online_booking_ticket.movie_online_booking_ticket.entities.Genre;
//import com.online_booking_ticket.movie_online_booking_ticket.repositories.GenreRepo;
//import com.online_booking_ticket.movie_online_booking_ticket.services.GenreService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@ActiveProfiles("test")
//public class GenreServiceIntegrationTest {
//
//    @Autowired
//    private GenreService genreService;
//
//    @Autowired
//    private GenreRepo genreRepo;
//
//    @BeforeEach
//    public void setUp() {
//        genreRepo.deleteAll();
//    }
//
//    @Test
//    public void testAddGenre() {
//        GenreRequest genreRequest = new GenreRequest();
//        genreRequest.setName("Action");
//
//        GenreResponse result = genreService.addGenre(genreRequest);
//
//        assertThat(result).isNotNull();
//        assertThat(result.getName()).isEqualTo("Action");
//
//        Genre savedGenre = genreRepo.findById(result.getId()).orElse(null);
//        assertThat(savedGenre).isNotNull();
//        assertThat(savedGenre.getName()).isEqualTo("Action");
//    }
//}
