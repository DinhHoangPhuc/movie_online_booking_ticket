package com.online_booking_ticket.movie_online_booking_ticket.instant;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PUBLIC)
public final class ControllerPath {
    public static final String GENRE_CONTROLLER = "/genres";
    public static final String COUNTRY_CONTROLLER = "/countries";
    public static final String ACTOR_CONTROLLER = "/actors";
    public static final String DIRECTOR_CONTROLLER = "/directors";
}
