package com.example.ticket_booking_system.dto;

import com.example.ticket_booking_system.enums.SeatStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeatResponseDTO {

    private Long id;
    private Long showId;
    private Long seatId;
    private String seatNumber;
    private String seatType;
    private Double price;
    private SeatStatus status;
}
