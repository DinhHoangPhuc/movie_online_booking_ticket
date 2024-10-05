package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.DirectorRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.DirectorResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Director;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DirectorMapperTest {

    private final DirectorMapper directorMapper = Mappers.getMapper(DirectorMapper.class);

    @Test
    public void directorRequestToDirector() {
        // given
        DirectorRequest directorRequest = new DirectorRequest();
        directorRequest.setName("James Cameron");
        directorRequest.setBirthDate(LocalDate.of(1954, 8, 16));
        directorRequest.setPicture("https://upload.wikimedia.org/wikipedia/commons/1/1e/James_Cameron_by_Gage_Skidmore.jpg");
        directorRequest.setCountryID("1");

        // when
        Director director = directorMapper.directorRequestToDirector(directorRequest);

        // then
        assertEquals(director.getName(), directorRequest.getName());
        assertEquals(director.getBirthDate(), directorRequest.getBirthDate());
        assertEquals(director.getPicture(), directorRequest.getPicture());
        assertEquals(director.getCountryID(), directorRequest.getCountryID());
    }

    @Test
    public void directorToDirectorResponse() {
        // given
        Director director = new Director();
        director.setId("1");
        director.setName("James Cameron");
        director.setBirthDate(LocalDate.of(1954, 8, 16));
        director.setPicture("https://upload.wikimedia.org/wikipedia/commons/1/1e/James_Cameron_by_Gage_Skidmore.jpg");
        director.setCountryID("1");
        director.setMovieIDs(new ArrayList<>());

        // when
        DirectorResponse directorResponse = directorMapper.directorToDirectorResponse(director);

        // then
        assertEquals(directorResponse.getId(), director.getId());
        assertEquals(directorResponse.getName(), director.getName());
        assertEquals(directorResponse.getBirthDate(), director.getBirthDate());
        assertEquals(directorResponse.getPicture(), director.getPicture());
        assertEquals(directorResponse.getCountryID(), director.getCountryID());
        assertEquals(directorResponse.getMovieIDs(), director.getMovieIDs());
    }
}