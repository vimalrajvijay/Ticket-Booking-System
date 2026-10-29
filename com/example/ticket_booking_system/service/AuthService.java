package com.example.ticket_booking_system.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ticket_booking_system.dto.AuthResponseDTO;
import com.example.ticket_booking_system.dto.LoginRequestDTO;
import com.example.ticket_booking_system.dto.RegisterRequestDTO;
import com.example.ticket_booking_system.dto.UserResponseDTO;
import com.example.ticket_booking_system.entity.User;
import com.example.ticket_booking_system.repository.UserRepository;
import com.example.ticket_booking_system.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;

    public UserResponseDTO register(RegisterRequestDTO requestDTO) {

        if (userRepository.existsByEmail(requestDTO.getEmail())) {
            throw new IllegalArgumentException(
                    "Email is already registered");
        }

        User user = modelMapper.map(requestDTO, User.class);

        user.setPassword(
                passwordEncoder.encode(requestDTO.getPassword()));

        user.setRole("CUSTOMER");

        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserResponseDTO.class);
    }

    public AuthResponseDTO login(LoginRequestDTO requestDTO) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDTO.getEmail(),
                        requestDTO.getPassword()));

        String token = jwtService.generateToken(
                requestDTO.getEmail());

        return new AuthResponseDTO(token, "Bearer");
    }
}
