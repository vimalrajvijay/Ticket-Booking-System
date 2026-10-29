package com.example.ticket_booking_system.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ticket_booking_system.dto.UserResponseDTO;
import com.example.ticket_booking_system.dto.UserUpdateRequestDTO;
import com.example.ticket_booking_system.entity.User;
import com.example.ticket_booking_system.exception.ResourceNotFoundException;
import com.example.ticket_booking_system.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserResponseDTO getMyProfile(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found with email: " + email));

        return modelMapper.map(user, UserResponseDTO.class);
    }

    public UserResponseDTO updateMyProfile(
            String email,
            UserUpdateRequestDTO requestDTO) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found with email: " + email));

        modelMapper.map(requestDTO, user);

        User updatedUser = userRepository.save(user);

        return modelMapper.map(updatedUser, UserResponseDTO.class);
    }

    public Page<UserResponseDTO> getAllUsers(Pageable pageable) {

        return userRepository.findAll(pageable) // map present in Page
                .map(user -> modelMapper.map(
                        user, UserResponseDTO.class));// Converting user into UserResponseDTO
    }
}
