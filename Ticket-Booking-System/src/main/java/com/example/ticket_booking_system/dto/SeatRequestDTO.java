package com.example.ticket_booking_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotBlank
    private String seatType;

    @NotNull
    @Positive
    private Long screenId;
}
