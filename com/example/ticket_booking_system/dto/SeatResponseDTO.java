package com.example.ticket_booking_system.dto;

import com.example.ticket_booking_system.enums.SeatType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatResponseDTO {

    private Long id;
    private String seatNumber;
    private SeatType seatType;
    private Long screenId;
    private String screenName;
}
