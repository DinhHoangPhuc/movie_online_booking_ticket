package com.online_booking_ticket.movie_online_booking_ticket.services;

import com.online_booking_ticket.movie_online_booking_ticket.repositories.ScreenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Screen;

@Service
public class ScreenService {

    @Autowired
    private ScreenRepo screenRepo;

    public Screen getScreenById(int screenId) {
        try {
            return screenRepo.findById(screenId).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // public Cinema getCinemaByScreenId(int screenId) {
    //     try {
    //         return screenRepo.findCinemaByScreenId(screenId);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }
}
