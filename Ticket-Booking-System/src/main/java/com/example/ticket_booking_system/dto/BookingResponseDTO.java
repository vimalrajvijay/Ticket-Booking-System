package com.example.ticket_booking_system.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.ticket_booking_system.enums.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseDTO {

    private Long id;
    private String bookingReference;
    private Long userId;
    private Long showId;
    private String movieTitle;
    private LocalDateTime showStartTime;
    private Double totalAmount;
    private BookingStatus status;
    private LocalDateTime bookingTime;
    private List<BookingSeatResponseDTO> seats;
}
