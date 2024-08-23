// package com.online_booking_ticket.movie_online_booking_ticket.sercurity.filters;

// import java.io.IOException;

// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import com.online_booking_ticket.movie_online_booking_ticket.sercurity.managers.CustomAuthenticationManager;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import lombok.AllArgsConstructor;

// @AllArgsConstructor
// @Component
// public class CustomAuthenticationFilter extends OncePerRequestFilter {

//     private final CustomAuthenticationManager customAuthenticationManager;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {

//         var authentication = customAuthenticationManager.authenticate(null);

//         if(authentication.isAuthenticated()) {
//             SecurityContextHolder.getContext().setAuthentication(authentication); // set the authentication object in the security context for authorization later
//             filterChain.doFilter(request, response);
//         }
//     }

    
// }
