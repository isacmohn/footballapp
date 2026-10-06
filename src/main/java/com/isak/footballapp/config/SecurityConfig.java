package com.isak.footballapp.config;

import com.isak.footballapp.repository.UserRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class SecurityConfig {

    // Bruker BCrypt for å kontrollere passord
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // Forteller Spring Security hvor brukerne skal hentes fra
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {

        return email -> {

            com.isak.footballapp.entity.User user =
                userRepository.findUserByEmail(email)
                    .orElseThrow(() ->
                        new UsernameNotFoundException("User not found")
                    );

            return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
        };
    }


    // Bestemmer hvilke HTTP-endpoints som krever autentisering
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                // Disse kan brukes uten autentisering
                .requestMatchers(
                    "/api/auth/register",
                    "/api/auth/login"
                ).permitAll()

                // Alt annet krever autentisering
                .anyRequest().authenticated()
            )

            // Tillater HTTP Basic Authentication
            .httpBasic(basic -> {});

        return http.build();
    }
}
