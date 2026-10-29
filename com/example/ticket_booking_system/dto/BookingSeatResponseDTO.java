package com.example.ticket_booking_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingSeatResponseDTO {

    private Long id;

    private Long bookingId;

    private Long showSeatId;

    private Double priceAtBooking;
}
