package com.online_booking_ticket.movie_online_booking_ticket.sercurity.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.online_booking_ticket.movie_online_booking_ticket.repositories.UserRepo;
import com.online_booking_ticket.movie_online_booking_ticket.sercurity.SecurityUser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SecurityUserService implements UserDetailsService {

    private final UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(username);

        return user.map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
