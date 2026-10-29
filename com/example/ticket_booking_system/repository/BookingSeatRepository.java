package com.example.ticket_booking_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ticket_booking_system.entity.BookingSeat;

public interface BookingSeatRepository extends JpaRepository<BookingSeat, Long> {

	List<BookingSeat> findByBookingId(Long bookingId);
}
