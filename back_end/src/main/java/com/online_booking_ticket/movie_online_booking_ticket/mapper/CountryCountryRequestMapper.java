package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.CountryRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.CountryResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryCountryRequestMapper {
    Country countryRequestToCountry(CountryRequest countryRequest);
    CountryResponse countryToCountryResponse(Country country);
}
