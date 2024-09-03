package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import com.online_booking_ticket.movie_online_booking_ticket.dto.RegisterResponseDTO;
import com.online_booking_ticket.movie_online_booking_ticket.services.TokenService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.online_booking_ticket.movie_online_booking_ticket.dto.LoginRequestDTO;
import com.online_booking_ticket.movie_online_booking_ticket.dto.RegisterRequestDTO;
import com.online_booking_ticket.movie_online_booking_ticket.services.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequestDTO registrationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> error = new HashMap<>();
            bindingResult.getFieldErrors().forEach(fieldError -> {
                error.put(fieldError.getField(), fieldError.getDefaultMessage());
            });
            System.out.println(error);
            return ResponseEntity.badRequest().body(error);
        } else {
            System.out.println("Registering user");
            RegisterResponseDTO registerResponseDTO = userService.registerNewUser(registrationDto);
            return new ResponseEntity<>(registerResponseDTO, HttpStatus.CREATED);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUserName(), loginRequestDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenService.generateToken(authentication);
        Cookie cookie = new Cookie("JWT", token);
        cookie.setHttpOnly(true);
//        cookie.setSecure(true); // Ensure this is set to true in production
        cookie.setPath("/");
        cookie.setMaxAge(3600); // 1 hour

        response.addCookie(cookie);

        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("name", authentication.getName());
        responseMap.put("message", "Login successful");

        return ResponseEntity.ok().body(responseMap);
    }

    @GetMapping("/cookie")
    public ResponseEntity<?> getCookie() {
        return ResponseEntity.ok().body("Cookie received");
    }
}
