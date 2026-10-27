package com.example.ticket_booking_system.dto;

import java.time.LocalDateTime;

import com.example.ticket_booking_system.enums.ShowStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowResponseDTO {

    private Long id;
    private Long movieId;
    private String movieTitle;
    private Long screenId;
    private String screenName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double basePrice;
    private ShowStatus status;
}
