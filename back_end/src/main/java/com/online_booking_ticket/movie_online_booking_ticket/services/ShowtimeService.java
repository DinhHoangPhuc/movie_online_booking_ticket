package com.online_booking_ticket.movie_online_booking_ticket.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.online_booking_ticket.movie_online_booking_ticket.dto.*;
import com.online_booking_ticket.movie_online_booking_ticket.entities.*;
import com.online_booking_ticket.movie_online_booking_ticket.execptionHandler.ShowtimeConflictException;
import com.online_booking_ticket.movie_online_booking_ticket.mapper.ShowtimeMapper;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShowtimeService{
    @Autowired
    private ShowtimeRepo showtimeRepository;

    @Autowired
    private ScreenRepo screenRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ShowtimeMapper showtimeMapper;

    @Transactional
    public ShowTimeResponse addShowtime(ShowTimeRequest showTimeRequest) {
        Showtime showtime = showtimeMapper.mapRequestToEntity(showTimeRequest);

        if(isShowtimeConflict(showtime.getScreenID(), showtime.getDate(), showtime.getStartTime(), showtime.getEndTime())) {
            throw new ShowtimeConflictException("Trùng lịch chiếu, vui lòng chọn lại");
        }

        Showtime savedShowtime = showtimeRepository.save(showtime);

        updateScreenShowtimes(showtime.getScreenID(), savedShowtime.getId());

        return showtimeMapper.mapEntityToResponse(savedShowtime);
    }

    public ArrayList<ShowTimeResponse> getAllShowtimes() {
        ArrayList<ShowTimeResponse> showtimeResponses = new ArrayList<>();
        for (Showtime showtime : showtimeRepository.findAll()) {
            showtimeResponses.add(showtimeMapper.mapEntityToResponse(showtime));
        }
        return showtimeResponses;
    }

    private boolean isShowtimeConflict(String screenID, LocalDate date, LocalTime startTime, LocalTime endTime) {
        ArrayList<Showtime> existingShowtimes = getShowtimesByScreenIDAndData(screenID, date);

        for (Showtime showtime : existingShowtimes) {
            if (startTime.isBefore(showtime.getEndTime()) && endTime.isAfter(showtime.getStartTime())) {
                return true;
            }
        }

        return false;
    }

    private ArrayList<Showtime> getShowtimesByScreenIDAndData(String screenID, LocalDate date) {
        Query query = new Query();
        query.addCriteria(Criteria.where("ScreenID").is(screenID).and("Date").is(date));

        return (ArrayList<Showtime>) mongoTemplate.find(query, Showtime.class);
    }

    private void updateScreenShowtimes(String screenID, String showtimeID) {
        Screen screen = screenRepo.findById(screenID).orElseThrow(() -> new RuntimeException("Screen not found"));
        screen.getShowtimeIDs().add(showtimeID);
        screenRepo.save(screen);
    }
}
