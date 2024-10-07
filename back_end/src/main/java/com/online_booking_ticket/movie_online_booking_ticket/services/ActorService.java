package com.online_booking_ticket.movie_online_booking_ticket.services;

import com.online_booking_ticket.movie_online_booking_ticket.dto.ActorRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.ActorResponse;
import com.online_booking_ticket.movie_online_booking_ticket.mapper.ActorMapper;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Actor;

import java.util.ArrayList;
import java.util.List;

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

    public List<ActorResponse> getActors() {
        List<Actor> actors = actorRepo.findAll();
        List<ActorResponse> actorResponses = new ArrayList<>();

        for (Actor actor : actors) {
            actorResponses.add(actorMapper.actorToActorResponse(actor));
        }

        return actorResponses;
    }
}
