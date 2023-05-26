package com.ty.springBoot_foodApp.exception;

public class UserNotFoundFoundException extends RuntimeException {

	private String message="id not found";

	

	@Override
	public String getMessage() {
		return message;
	}



	public UserNotFoundFoundException(String message) {
		super();
		this.message = message;
	}
	
	
	
}
