package com.example.ticket_booking_system.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.ticket_booking_system.security.CustomUserDetailsService;
import com.example.ticket_booking_system.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(
			HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) {

		http.csrf(csrf -> csrf.disable());
		
		http.sessionManagement(session -> session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
//		http.authorizeHttpRequests(auth -> auth
//
//                // Authentication: public endpoints
//                .requestMatchers(
//                    "/api/v1/auth/register",
//                    "/api/v1/auth/login"
//                ).permitAll()
//
//                // Swagger UI
//                .requestMatchers(
//                    "/swagger-ui/**",
//                    "/v3/api-docs/**"
//                ).permitAll()
//
//                // Public movie browsing
//                .requestMatchers(
//                    HttpMethod.GET,
//                    "/api/v1/movies",
//                    "/api/v1/movies/**"
//                ).permitAll()
//
//                // Public theatre browsing
//                .requestMatchers(
//                    HttpMethod.GET,
//                    "/api/v1/theatres",
//                    "/api/v1/theatres/**"
//                ).permitAll()
//
//                // Public show browsing
//                .requestMatchers(
//                    HttpMethod.GET,
//                    "/api/v1/shows",
//                    "/api/v1/shows/**"
//                ).permitAll()
//
//                // Public seat availability
//                .requestMatchers(
//                    HttpMethod.GET,
//                    "/api/v1/shows/*/seats"
//                ).permitAll()
//
//                // Admin: user listing
//                .requestMatchers(
//                    HttpMethod.GET,
//                    "/api/v1/users"
//                ).hasRole("ADMIN")
//
//                // Authenticated user: own profile
//                .requestMatchers(
//                    "/api/v1/users/me"
//                ).hasAnyRole("CUSTOMER", "ADMIN")
//
//                // Admin: create/update/delete movies
//                .requestMatchers(
//                    "/api/v1/movies/**"
//                ).hasRole("ADMIN")
//
//                // Admin: manage theatres and screens
//                .requestMatchers(
//                    "/api/v1/theatres/**"
//                ).hasRole("ADMIN")
//
//                // Admin: manage shows
//                .requestMatchers(
//                    "/api/v1/shows/**"
//                ).hasRole("ADMIN")
//
//                // Booking endpoints: authenticated users
//                .requestMatchers(
//                    "/api/v1/bookings/**"
//                ).hasAnyRole("CUSTOMER", "ADMIN")
//
//                // Everything else requires authentication
//                .anyRequest().authenticated()
//            );

		http.addFilterBefore(jwtAuthenticationFilter, 
				UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration configuration) {
		return configuration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider(
			PasswordEncoder passwordEncoder, 
			CustomUserDetailsService userDetailsService) {
		DaoAuthenticationProvider dao = 
				new DaoAuthenticationProvider(userDetailsService);
		dao.setPasswordEncoder(passwordEncoder);
		return dao;
	}
}
