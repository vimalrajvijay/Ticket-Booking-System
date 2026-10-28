package com.example.ticket_booking_system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket_booking_system.dto.TheatreRequestDTO;
import com.example.ticket_booking_system.dto.TheatreResponseDTO;
import com.example.ticket_booking_system.service.TheatreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/theatres")
@RequiredArgsConstructor
public class TheatreController {

    private final TheatreService theatreService;

    @PostMapping
    public ResponseEntity<TheatreResponseDTO> addTheatre(
            @Valid @RequestBody TheatreRequestDTO requestDTO) {

    	return new ResponseEntity<>(
    			theatreService.addTheatre(requestDTO), 
        		HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TheatreResponseDTO>> getAllTheatres() {
    	return new ResponseEntity<>(
    			theatreService.getAllTheatres(), 
        		HttpStatus.OK);
    }
}
