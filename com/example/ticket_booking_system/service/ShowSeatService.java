package com.example.ticket_booking_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ticket_booking_system.entity.ShowSeat;
import com.example.ticket_booking_system.repository.ShowSeatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShowSeatService {

    private final ShowSeatRepository showSeatRepository;

    public List<ShowSeat> getShowSeats(Long showId) {
        return showSeatRepository.findByShowId(showId);
    }
}
