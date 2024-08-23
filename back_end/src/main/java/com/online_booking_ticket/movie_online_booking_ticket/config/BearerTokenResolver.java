package com.online_booking_ticket.movie_online_booking_ticket.config;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class BearerTokenResolver implements org.springframework.security.oauth2.server.resource.web.BearerTokenResolver {
    private static final String COOKIE_NAME = "JWT";

    @Override
    public String resolve(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (COOKIE_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
