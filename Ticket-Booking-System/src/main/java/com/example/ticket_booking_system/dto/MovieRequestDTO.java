package com.example.ticket_booking_system.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequestDTO {
	
	@NotBlank
	private String title;
	
	private String description;
	@NotBlank
	private String genre;
	@NotBlank
	private String language;
	@Positive
	private Integer duration;
	@NotNull
	private LocalDate releaseDate;
	@NotBlank
	private String certificate;
}
