package com.example.ticket_booking_system.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket_booking_system.dto.BookingSeatResponseDTO;
import com.example.ticket_booking_system.service.BookingSeatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingSeatController {

    private final BookingSeatService bookingSeatService;

    @GetMapping("/{bookingId}/seats")
    public ResponseEntity<List<BookingSeatResponseDTO>> getBookingSeats(
            @PathVariable Long bookingId) {

        return ResponseEntity.ok(
                bookingSeatService.getBookingSeats(bookingId));
    }
}
