package com.restBloggingApp.main.exception;

public class UserAlreadyExistedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserAlreadyExistedException() {
		super("User already existed with provided emailId!!!");
	}
	
	
	
}
