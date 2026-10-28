package com.example.ticket_booking_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ticket_booking_system.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	List<Movie> findByTitleIgnoreCase(String title);
	
	List<Movie> findByGenreIgnoreCase(String genre);
	
}
