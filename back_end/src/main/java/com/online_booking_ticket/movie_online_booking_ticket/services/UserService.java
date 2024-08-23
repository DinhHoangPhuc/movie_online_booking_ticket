package com.online_booking_ticket.movie_online_booking_ticket.services;

import com.online_booking_ticket.movie_online_booking_ticket.dto.RegisterResponseDTO;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.online_booking_ticket.movie_online_booking_ticket.dto.RegisterRequestDTO;
import com.online_booking_ticket.movie_online_booking_ticket.entities.User;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public RegisterResponseDTO registerNewUser(RegisterRequestDTO registrationDto) {
        User user = new User();
        user.setName(registrationDto.getName());
        user.setEmail(registrationDto.getEmail());
        user.setPhoneNumber(registrationDto.getPhoneNumber());
        user.setDateOfBirth(registrationDto.getDateOfBirth());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        userRepo.save(user);
        return new RegisterResponseDTO(user.getName(), user.getEmail(), user.getPhoneNumber(), user.getDateOfBirth());
    }

    // public ResponseEntity<?> login(UserLogin loginDto) {
    //     try {
    //          Authentication authentication = authenticationManager.authenticate(
    //             new UsernamePasswordAuthenticationToken(
    //                 loginDto.getUserName(),
    //                 loginDto.getPassword()
    //             )
    //     );

    //     if(authentication.isAuthenticated()) {
    //         SecurityContextHolder.getContext().setAuthentication(authentication);
    //         return new ResponseEntity<>(authentication.getPrincipal(), HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    //     }
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    //     }
    // }
}
