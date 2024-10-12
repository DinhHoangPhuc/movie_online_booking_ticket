package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import com.online_booking_ticket.movie_online_booking_ticket.dto.ScreenRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.ScreenResponse;
import com.online_booking_ticket.movie_online_booking_ticket.instant.ControllerPath;
import com.online_booking_ticket.movie_online_booking_ticket.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerPath.SCREEN_CONTROLLER)
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    @PostMapping
    public ResponseEntity<ScreenResponse> addScreen(@RequestBody ScreenRequest screenRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(screenService.addScreen(screenRequest));
    }
}
