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
public class ScreenRequestDTO {

    @NotBlank
    private String screenName;

    @NotNull
    @Positive
    private Integer capacity;

    @NotNull
    @Positive
    private Long theatreId;
}
