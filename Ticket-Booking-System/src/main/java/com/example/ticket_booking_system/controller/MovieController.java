package com.example.ticket_booking_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket_booking_system.dto.MovieRequestDTO;
import com.example.ticket_booking_system.dto.MovieResponseDTO;
import com.example.ticket_booking_system.service.MovieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
public class MovieController {
	
	private final MovieService movieService;
	
	@PostMapping
	public ResponseEntity<MovieResponseDTO> createMovie(
			@RequestBody MovieRequestDTO movieRequestDTO){
		return new ResponseEntity<>(
				movieService.createMovie(movieRequestDTO), 
				HttpStatus.CREATED);
	}
}
