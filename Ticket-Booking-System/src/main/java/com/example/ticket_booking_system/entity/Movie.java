package com.example.ticket_booking_system.entity;

import java.time.LocalDate;

import com.example.ticket_booking_system.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String title;
	private String description;
	private String genre;
	private String language;
	private Integer duration;
	private LocalDate releaseDate;
	private String certificate;
	
	@Enumerated(EnumType.STRING)
	private Status status;
}
