package com.example.ticket_booking_system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping
	public ResponseEntity<List<MovieResponseDTO>> getAllMovies(){
		List<MovieResponseDTO> movieResponseDTOs 
		            = movieService.getAllMovies();
		return new ResponseEntity<>(
				movieResponseDTOs, 
				HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieResponseDTO> getMovieById(@PathVariable Long id){
		 return new ResponseEntity<>(
				movieService.getMovieById(id), 
				HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MovieResponseDTO> updateMovieById(
			@PathVariable Long id,
			@RequestBody MovieRequestDTO movieRequestDTO){
		
		return new ResponseEntity<>(
				movieService.updateMovieById(id, movieRequestDTO), 
				HttpStatus.OK);
	}
}
