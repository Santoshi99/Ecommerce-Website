package com.ecommapp.backendproject.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public String HandleResourceNotFoundException(ResourceNotFoundException exception) {
		return exception.getMessage();
	}
}
