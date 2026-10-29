package com.example.ticket_booking_system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket_booking_system.dto.MovieRequestDTO;
import com.example.ticket_booking_system.dto.MovieResponseDTO;
import com.example.ticket_booking_system.service.MovieService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
@Validated
public class MovieController {
	
	private final MovieService movieService;
	
	@PostMapping
	public ResponseEntity<MovieResponseDTO> createMovie(
			@Valid @RequestBody MovieRequestDTO movieRequestDTO){
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
	public ResponseEntity<MovieResponseDTO> getMovieById(
			@PathVariable @Positive Long id){
		 return new ResponseEntity<>(
				movieService.getMovieById(id), 
				HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MovieResponseDTO> updateMovieById(
			@PathVariable @Positive Long id,
			@Valid @RequestBody MovieRequestDTO movieRequestDTO){
		
		return new ResponseEntity<>(
				movieService.updateMovieById(id, movieRequestDTO), 
				HttpStatus.OK);
	}
	
	@GetMapping("/title")
    public ResponseEntity<List<MovieResponseDTO>> getAllMoviesByTitle(
    		@RequestParam String title){
		return new ResponseEntity<>(
				movieService.getAllMoviesByTitle(title), 
				HttpStatus.OK);
    }
    
    @GetMapping("/genre")
    public ResponseEntity<List<MovieResponseDTO>> getAllMoviesByGenre(
    		@RequestParam String genre){
    	return new ResponseEntity<>(
    			movieService.getAllMoviesByGenre(genre), 
				HttpStatus.OK);
    }
}
