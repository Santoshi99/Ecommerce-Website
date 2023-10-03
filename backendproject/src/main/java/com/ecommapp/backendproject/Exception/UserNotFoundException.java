package com.ecommapp.backendproject.Exception;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String message) {
	   super(message);
	}
	public UserNotFoundException( ) {
		super();
		}
}
