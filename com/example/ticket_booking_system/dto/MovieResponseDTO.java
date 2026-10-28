package com.example.ticket_booking_system.dto;

import java.time.LocalDate;

import com.example.ticket_booking_system.enums.MovieStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDTO {

	private Long id;
	private String title;
	private String description;
	private String genre;
	private String language;
	private Integer duration;
	private LocalDate releaseDate;
	private String certificate;
	private MovieStatus status;
}
