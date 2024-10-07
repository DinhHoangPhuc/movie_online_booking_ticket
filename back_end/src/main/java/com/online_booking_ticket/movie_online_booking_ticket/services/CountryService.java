package com.online_booking_ticket.movie_online_booking_ticket.services;

import com.online_booking_ticket.movie_online_booking_ticket.dto.CountryRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.CountryResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Country;
import com.online_booking_ticket.movie_online_booking_ticket.mapper.CountryCountryRequestMapper;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private CountryCountryRequestMapper countryCountryRequestMapper;

    public CountryResponse addCountry(CountryRequest countryRequest) {
        Country country = countryCountryRequestMapper.countryRequestToCountry(countryRequest);
        return countryCountryRequestMapper.countryToCountryResponse(countryRepo.save(country));
    }

    public List<CountryResponse> getCountries() {
        List<Country> countries = countryRepo.findAll();
        List<CountryResponse> countryResponses = new ArrayList<>();

        for (Country country : countries) {
            countryResponses.add(countryCountryRequestMapper.countryToCountryResponse(country));
        }

        return countryResponses;
    }
}
