package com.example.ticket_booking_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ticket_booking_system.entity.ShowSeat;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long>{

	List<ShowSeat> findByShowId(Long showId);
}
