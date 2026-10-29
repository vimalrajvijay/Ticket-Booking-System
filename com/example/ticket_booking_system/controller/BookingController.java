package com.example.ticket_booking_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket_booking_system.dto.BookingResponseDTO;
import com.example.ticket_booking_system.service.BookingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/users/{userId}/shows/{showId}/seats/{showSeatId}")
    public ResponseEntity<BookingResponseDTO> createBooking(
            @PathVariable Long userId,
            @PathVariable Long showId,
            @PathVariable Long showSeatId) {

        BookingResponseDTO responseDTO = bookingService.createBooking(
                userId, showId, showSeatId);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
