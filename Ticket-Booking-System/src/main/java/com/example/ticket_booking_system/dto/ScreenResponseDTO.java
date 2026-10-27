package com.example.ticket_booking_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScreenResponseDTO {

    private Long id;
    private String screenName;
    private Integer capacity;
    private Long theatreId;
    private String theatreName;
}