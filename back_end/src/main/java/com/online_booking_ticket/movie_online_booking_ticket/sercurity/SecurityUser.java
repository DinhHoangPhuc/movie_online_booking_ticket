package com.online_booking_ticket.movie_online_booking_ticket.sercurity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.online_booking_ticket.movie_online_booking_ticket.repositories.AuthorityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.online_booking_ticket.movie_online_booking_ticket.entities.User;

import lombok.AllArgsConstructor;

@RequiredArgsConstructor
public class SecurityUser implements UserDetails {

    private final User user;

    @Autowired
    private AuthorityRepo authorityRepo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorityIDs()
                .stream()
                .map(authorityId -> new SecurityAuthority(authorityRepo.findById(authorityId).orElseThrow()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
