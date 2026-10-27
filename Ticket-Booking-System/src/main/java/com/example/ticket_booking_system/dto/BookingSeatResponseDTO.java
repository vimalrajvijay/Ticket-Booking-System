package com.example.ticket_booking_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingSeatResponseDTO {

    private Long id;
    private Long showSeatId;
    private String seatNumber;
    private String seatType;
    private Double bookedPrice;
}
