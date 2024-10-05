package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import com.online_booking_ticket.movie_online_booking_ticket.dto.CountryRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.CountryResponse;
import com.online_booking_ticket.movie_online_booking_ticket.instant.ControllerPath;
import com.online_booking_ticket.movie_online_booking_ticket.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerPath.COUNTRY_CONTROLLER)
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryResponse> addCountry(@RequestBody CountryRequest countryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(countryService.addCountry(countryRequest));
    }
}
