package com.example.ticket_booking_system.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.ticket_booking_system.dto.ShowRequestDTO;
import com.example.ticket_booking_system.dto.ShowResponseDTO;
import com.example.ticket_booking_system.entity.Movie;
import com.example.ticket_booking_system.entity.Screen;
import com.example.ticket_booking_system.entity.Show;
import com.example.ticket_booking_system.enums.MovieStatus;
import com.example.ticket_booking_system.enums.ShowStatus;
import com.example.ticket_booking_system.exception.ResourceNotFoundException;
import com.example.ticket_booking_system.repository.MovieRepository;
import com.example.ticket_booking_system.repository.ScreenRepository;
import com.example.ticket_booking_system.repository.ShowRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;
    private final ModelMapper modelMapper;

    public ShowResponseDTO addShow(Long movieId, Long screenId, ShowRequestDTO requestDTO) {

        if (!requestDTO.getEndTime().isAfter(requestDTO.getStartTime())) {
            throw new IllegalArgumentException(
                    "End time must be after start time");
        }

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Movie not found with ID: " + movieId));

        if (movie.getStatus() != MovieStatus.ACTIVE) {
            throw new IllegalArgumentException(
                    "Cannot schedule a show for an inactive movie");
        }

        Screen screen = screenRepository.findById(screenId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Screen not found with ID: " + screenId));

        boolean overlapping = showRepository.existsOverlappingShow(
                screenId,
                requestDTO.getShowDate(),
                requestDTO.getStartTime(),
                requestDTO.getEndTime());

        if (overlapping) {
            throw new IllegalArgumentException(
                    "Another show is already scheduled during this time on the screen");
        }

        Show show = modelMapper.map(requestDTO, Show.class);

        
        show.setMovie(movie);
        show.setScreen(screen);
        show.setStatus(ShowStatus.SCHEDULED);

        Show savedShow = showRepository.save(show);
        ShowResponseDTO responseDTO = modelMapper.map(savedShow, ShowResponseDTO.class);
        responseDTO.setTheatreId(screen.getTheatre().getId());
        responseDTO.setTheatreName(screen.getTheatre().getName());
        
        return responseDTO;
    }

    public List<ShowResponseDTO> getAllShows(
            Long movieId, Long theatreId, LocalDate showDate) {

        List<Show> shows = showRepository.findShowsByFilters(
                movieId, theatreId, showDate);
        List<ShowResponseDTO> responseDTOs = new ArrayList<>();
        for(Show show : shows) {
        	responseDTOs.add(modelMapper.map(show, ShowResponseDTO.class));
        }

        return responseDTOs;
    }

    public ShowResponseDTO getShowById(Long id) {

        Show show = showRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Show not found with ID: " + id));

        return modelMapper.map(show, ShowResponseDTO.class);
    }
}
