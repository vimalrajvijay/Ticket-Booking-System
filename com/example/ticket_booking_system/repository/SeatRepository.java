package com.example.ticket_booking_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ticket_booking_system.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    boolean existsByScreenIdAndSeatNumber(
            Long screenId,
            String seatNumber
    );

    List<Seat> findByScreenId(Long screenId);
}