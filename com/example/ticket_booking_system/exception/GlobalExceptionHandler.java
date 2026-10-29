package com.example.ticket_booking_system.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex){
		return new ResponseEntity<>(
				ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex){
		return new ResponseEntity<>(
				ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<String> handleAuthendicationException(
			AuthenticationException ex){
		String message = ex.getMessage();
		return new ResponseEntity<String>(message, 
				HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex){
		Map<String, String> map = new HashMap<>();
		List<FieldError> errors = ex.getBindingResult().getFieldErrors();
		for(FieldError error : errors) {
			map.put(error.getField(), error.getDefaultMessage());
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
}
