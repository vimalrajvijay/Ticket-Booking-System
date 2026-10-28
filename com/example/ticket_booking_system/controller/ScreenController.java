package com.example.ticket_booking_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket_booking_system.dto.ScreenRequestDTO;
import com.example.ticket_booking_system.dto.ScreenResponseDTO;
import com.example.ticket_booking_system.service.ScreenService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/theatres/{theatreId}/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    @PostMapping
    public ResponseEntity<ScreenResponseDTO> addScreen(
            @PathVariable Long theatreId,
            @Valid @RequestBody ScreenRequestDTO requestDTO) {

        return new ResponseEntity<>(
        		screenService.addScreen(theatreId, requestDTO), 
        		HttpStatus.CREATED);
    }
}