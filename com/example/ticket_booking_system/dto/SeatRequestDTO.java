package com.example.ticket_booking_system.dto;

import com.example.ticket_booking_system.enums.SeatType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequestDTO {

    @NotBlank
    private String seatNumber;

    @NotNull
    private SeatType seatType;
}
