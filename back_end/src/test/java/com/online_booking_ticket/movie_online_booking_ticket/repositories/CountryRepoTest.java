package com.online_booking_ticket.movie_online_booking_ticket.repositories;

import com.online_booking_ticket.movie_online_booking_ticket.config.MongoTestConfig;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@Import(MongoTestConfig.class)
class CountryRepoTest {

    @Autowired
    private CountryRepo countryRepo;

    @BeforeEach
    void setUp() {
        countryRepo.deleteAll();
    }

    @Test
    public void testSaveCountry() {
        Country country = new Country();
        country.setName("Vietnam");

        Country savedCountry = countryRepo.save(country);

        assertThat(savedCountry).isNotNull();
        assertThat(savedCountry.getId()).isEqualTo(country.getId());
        assertThat(savedCountry.getName()).isEqualTo("Vietnam");
    }
}