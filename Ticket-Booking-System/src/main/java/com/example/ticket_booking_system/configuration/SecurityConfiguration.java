package com.example.ticket_booking_system.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
		
		http.csrf(csrf->csrf.disable());
		
		http.authorizeHttpRequests(auth->auth.anyRequest().permitAll());
		
		return http.build();
	}
}
