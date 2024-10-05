package com.online_booking_ticket.movie_online_booking_ticket.services;

import com.online_booking_ticket.movie_online_booking_ticket.dto.CountryRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.CountryResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Country;
import com.online_booking_ticket.movie_online_booking_ticket.mapper.CountryCountryRequestMapper;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.CountryRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CountryServiceTest {

    @Mock
    private CountryRepo countryRepo;

    @Mock
    private CountryCountryRequestMapper countryCountryRequestMapper;

    @InjectMocks
    private CountryService countryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCountry() {
        CountryRequest countryRequest = new CountryRequest();
        countryRequest.setName("Vietnam");

        Country country = new Country();
        country.setName("Vietnam");

        CountryResponse countryResponse = new CountryResponse();
        countryResponse.setName("Vietnam");

        when(countryCountryRequestMapper.countryRequestToCountry(any(CountryRequest.class))).thenReturn(country);
        when(countryRepo.save(any(Country.class))).thenReturn(country);
        when(countryCountryRequestMapper.countryToCountryResponse(any(Country.class))).thenReturn(countryResponse);

        CountryResponse result = countryService.addCountry(countryRequest);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Vietnam");
    }
}