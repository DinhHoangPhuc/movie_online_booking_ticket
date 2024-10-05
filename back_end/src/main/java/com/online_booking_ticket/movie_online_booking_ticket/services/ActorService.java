package com.online_booking_ticket.movie_online_booking_ticket.services;

import com.online_booking_ticket.movie_online_booking_ticket.dto.ActorRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.ActorResponse;
import com.online_booking_ticket.movie_online_booking_ticket.mapper.ActorMapper;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Actor;

@Service
public class ActorService {

    @Autowired
    private ActorRepo actorRepo;

    @Autowired
    private ActorMapper actorMapper;

    public ActorResponse addActor(ActorRequest actorRequest) {
        Actor actor = actorMapper.actorRequestToActor(actorRequest);
        return actorMapper.actorToActorResponse(actorRepo.save(actor));
    }
}
