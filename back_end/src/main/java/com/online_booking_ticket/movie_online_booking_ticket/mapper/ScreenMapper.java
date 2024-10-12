package com.online_booking_ticket.movie_online_booking_ticket.mapper;

import com.online_booking_ticket.movie_online_booking_ticket.dto.ScreenRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.ScreenResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Screen;

public class ScreenMapper {

    public static ScreenResponse toScreenResponse(Screen screen) {
        ScreenResponse screenResponse = new ScreenResponse();
        screenResponse.setId(screen.getId());
        screenResponse.setCinemaID(screen.getCinemaID());
        screenResponse.setScreenNumber(screen.getScreenNumber());
        screenResponse.setTotalRows(screen.getTotalRows());
        screenResponse.setTotalColumns(screen.getTotalColumns());
        screenResponse.setSeatIDs(screen.getSeatIDs());
        screenResponse.setShowtimeIDs(screen.getShowtimeIDs());
        return screenResponse;
    }

    public static Screen toScreen(ScreenRequest screenRequest) {
        Screen screen = new Screen();
        screen.setCinemaID(screenRequest.getCinemaID());
        screen.setScreenNumber(screenRequest.getScreenNumber());
        screen.setTotalRows(screenRequest.getTotalRows());
        screen.setTotalColumns(screenRequest.getTotalColumns());
        return screen;
    }
}
