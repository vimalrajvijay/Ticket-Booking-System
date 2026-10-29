package com.example.ticket_booking_system.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ticket_booking_system.entity.Booking;
import com.example.ticket_booking_system.enums.BookingStatus;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	@Query("""
		    SELECT b
		    FROM Booking b
		    WHERE b.status = :status
		      AND (
		          b.show.showDate < :today
		          OR (
		              b.show.showDate = :today
		              AND b.show.endTime <= :currentTime
		          )
		      )
		""")
		List<Booking> findBookingsForCompletedShows(
		        @Param("status") BookingStatus status,
		        @Param("today") LocalDate today,
		        @Param("currentTime") LocalTime currentTime);
}
