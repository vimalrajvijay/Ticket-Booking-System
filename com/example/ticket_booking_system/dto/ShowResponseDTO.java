package com.example.ticket_booking_system.dto;


import java.time.LocalDate;
import java.time.LocalTime;

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
	private Long theatreId;
	private String theatreName;
	private LocalDate showDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private Double ticketPrice;
	private ShowStatus status;
}
