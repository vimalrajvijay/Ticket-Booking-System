package com.example.ticket_booking_system.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.ticket_booking_system.dto.ScreenRequestDTO;
import com.example.ticket_booking_system.dto.ScreenResponseDTO;
import com.example.ticket_booking_system.entity.Screen;
import com.example.ticket_booking_system.entity.Theatre;
import com.example.ticket_booking_system.exception.ResourceNotFoundException;
import com.example.ticket_booking_system.repository.ScreenRepository;
import com.example.ticket_booking_system.repository.TheatreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScreenService {

    private final ScreenRepository screenRepository;
    private final TheatreRepository theatreRepository;
    private final ModelMapper modelMapper;

    public ScreenResponseDTO addScreen(
            Long theatreId, ScreenRequestDTO requestDTO) {
    	
        Theatre theatre = theatreRepository.findById(theatreId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Theatre not found"));
        Screen screen = modelMapper.map(requestDTO, Screen.class);
        screen.setTheatre(theatre);
        Screen savedScreen = screenRepository.save(screen);        
        return modelMapper.map(savedScreen, ScreenResponseDTO.class);
    }
}
