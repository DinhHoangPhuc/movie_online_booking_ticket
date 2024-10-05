package com.online_booking_ticket.movie_online_booking_ticket.services;

import com.online_booking_ticket.movie_online_booking_ticket.dto.DirectorRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.DirectorResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Director;
import com.online_booking_ticket.movie_online_booking_ticket.mapper.DirectorMapper;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepo directorRepo;

    @Autowired
    private DirectorMapper directorMapper;

    public DirectorResponse addDirector(DirectorRequest directorRequest) {
        Director director = directorMapper.directorRequestToDirector(directorRequest);
        return directorMapper.directorToDirectorResponse(directorRepo.save(director));
    }
}
