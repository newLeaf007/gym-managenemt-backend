package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleGlobalResourceNotFound(ResourceNotFoundException ex){
		
		String message = ex.getMessage();
		ApiResponse response = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
		
	}

}
