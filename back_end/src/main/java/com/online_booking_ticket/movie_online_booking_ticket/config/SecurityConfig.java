package com.online_booking_ticket.movie_online_booking_ticket.config;

import com.online_booking_ticket.movie_online_booking_ticket.instant.ControllerPath;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import lombok.AllArgsConstructor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@EnableConfigurationProperties(RsaKeyProperties.class)
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final RsaKeyProperties rsaKeyProperties;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests((authorize) -> {
                authorize.requestMatchers("ws/**").permitAll();
                authorize.requestMatchers("/app/seats").permitAll();
                authorize.requestMatchers(HttpMethod.POST, "/auth/register").permitAll();
                authorize.requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
                authorize.requestMatchers(HttpMethod.POST, ControllerPath.GENRE_CONTROLLER).permitAll();
                authorize.requestMatchers(HttpMethod.GET, ControllerPath.GENRE_CONTROLLER).permitAll();
                authorize.requestMatchers(HttpMethod.POST, ControllerPath.COUNTRY_CONTROLLER).permitAll();
                authorize.requestMatchers(HttpMethod.GET, ControllerPath.COUNTRY_CONTROLLER).permitAll();
                authorize.requestMatchers(HttpMethod.POST, ControllerPath.ACTOR_CONTROLLER).permitAll();
                authorize.requestMatchers(HttpMethod.GET, ControllerPath.ACTOR_CONTROLLER).permitAll();
                authorize.requestMatchers(HttpMethod.POST, ControllerPath.DIRECTOR_CONTROLLER).permitAll();
                authorize.requestMatchers(HttpMethod.GET, ControllerPath.DIRECTOR_CONTROLLER).permitAll();
                authorize.requestMatchers(HttpMethod.POST, ControllerPath.MOVIE_CONTROLLER).permitAll();
                authorize.requestMatchers(HttpMethod.GET, ControllerPath.MOVIE_CONTROLLER).permitAll();
                authorize.requestMatchers(HttpMethod.PUT, ControllerPath.MOVIE_CONTROLLER_PUT).permitAll();
                authorize.requestMatchers("/error").permitAll();
                authorize.anyRequest().authenticated();
            })
//            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .oauth2ResourceServer(oauth2 -> oauth2.bearerTokenResolver(bearerTokenResolver()).jwt(Customizer.withDefaults()))
            .httpBasic(Customizer.withDefaults())
            .csrf(AbstractHttpConfigurer::disable)
//            .cors(AbstractHttpConfigurer::disable)
            .build();
    }

    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public BearerTokenResolver bearerTokenResolver() {
        return new com.online_booking_ticket.movie_online_booking_ticket.config.BearerTokenResolver();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(rsaKeyProperties.publicKey()).build();
    }

    @Bean
    public JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(rsaKeyProperties.publicKey()).privateKey(rsaKeyProperties.privateKey()).build();
        JWKSource<SecurityContext> jwkSource = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwkSource);
    }
}