package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.CountryRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.CountryResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Country;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class CountryCountryRequestTest {

    private final CountryCountryRequestMapper countryCountryMappper = Mappers.getMapper(CountryCountryRequestMapper.class);

    @Test
    void countryRequestToCountry() {
        CountryRequest countryRequest = new CountryRequest();
        countryRequest.setName("India");

        Country country = countryCountryMappper.countryRequestToCountry(countryRequest);

        assert country.getName().equals("India");
    }

    @Test
    void countryToCountryResponse() {
        Country country = new Country();
        country.setId("1");
        country.setName("India");

        CountryResponse countryResponse = countryCountryMappper.countryToCountryResponse(country);

        assert countryResponse.getId().equals("1");
        assert countryResponse.getName().equals("India");
    }
}