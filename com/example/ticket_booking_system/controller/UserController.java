package com.example.ticket_booking_system.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket_booking_system.dto.UserResponseDTO;
import com.example.ticket_booking_system.dto.UserUpdateRequestDTO;
import com.example.ticket_booking_system.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Once the user is logged in Authentication Object is created.
	// By using the Authentication object we are getting email to perform following task
    
    @GetMapping("/me") // for differentiate end points
    public ResponseEntity<UserResponseDTO> getMyProfile(
            Authentication authentication) { 
    	
    	return new ResponseEntity<UserResponseDTO>(
    			userService.getMyProfile(authentication.getName()), HttpStatus.OK);
    }

    @PutMapping("/me")
    public ResponseEntity<UserResponseDTO> updateMyProfile(
            Authentication authentication,
            @Valid @RequestBody UserUpdateRequestDTO requestDTO) {

        return ResponseEntity.ok(
                userService.updateMyProfile(
                        authentication.getName(), requestDTO));
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> getAllUsers(
            Pageable pageable) {

        return ResponseEntity.ok(
                userService.getAllUsers(pageable));
    }
}
