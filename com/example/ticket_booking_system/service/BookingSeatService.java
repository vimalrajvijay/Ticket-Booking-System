package com.example.ticket_booking_system.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.ticket_booking_system.dto.BookingSeatResponseDTO;
import com.example.ticket_booking_system.entity.BookingSeat;
import com.example.ticket_booking_system.exception.ResourceNotFoundException;
import com.example.ticket_booking_system.repository.BookingRepository;
import com.example.ticket_booking_system.repository.BookingSeatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingSeatService {

    private final BookingSeatRepository bookingSeatRepository;
    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;

    public List<BookingSeatResponseDTO> getBookingSeats(Long bookingId) {

        if (!bookingRepository.existsById(bookingId)) {
            throw new ResourceNotFoundException(
                    "Booking not found with ID: " + bookingId);
        }

        List<BookingSeat> bookingSeats =
                bookingSeatRepository.findByBookingId(bookingId);

        List<BookingSeatResponseDTO> responseDTOs = new ArrayList<>();

        for (BookingSeat bookingSeat : bookingSeats) {

            BookingSeatResponseDTO dto = modelMapper.map(
                    bookingSeat, BookingSeatResponseDTO.class);

            dto.setBookingId(bookingSeat.getBooking().getId());
            dto.setShowSeatId(bookingSeat.getShowSeat().getId());

            responseDTOs.add(dto);
        }

        return responseDTOs;
    }
}
