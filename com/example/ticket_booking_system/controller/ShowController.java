package com.example.ticket_booking_system.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket_booking_system.dto.ShowRequestDTO;
import com.example.ticket_booking_system.dto.ShowResponseDTO;
import com.example.ticket_booking_system.service.ShowService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/shows")
@RequiredArgsConstructor
@Validated
public class ShowController {

    private final ShowService showService;

    @PostMapping("/{movieId}/{screenId}")
    public ResponseEntity<ShowResponseDTO> addShow(
    		@PathVariable Long movieId,
    		@PathVariable Long screenId,
            @Valid @RequestBody ShowRequestDTO requestDTO) {

        ShowResponseDTO response = showService.addShow( movieId, screenId, requestDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ShowResponseDTO>> getAllShows(
            @RequestParam(required = false) Long movieId,
            @RequestParam(required = false) Long theatreId,
            @RequestParam(required = false) LocalDate showDate) {

        List<ShowResponseDTO> shows =
                showService.getAllShows(movieId, theatreId, showDate);

        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowResponseDTO> getShowById(
            @PathVariable @Positive Long id) {

        ShowResponseDTO response = showService.getShowById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
