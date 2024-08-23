package com.online_booking_ticket.movie_online_booking_ticket.sercurity;

import org.springframework.security.core.GrantedAuthority;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Authority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Authority authority;

    @Override
    public String getAuthority() {
        return authority.getName();
    }

}
