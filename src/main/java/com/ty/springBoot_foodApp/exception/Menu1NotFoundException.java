package com.ty.springBoot_foodApp.exception;

public class Menu1NotFoundException extends RuntimeException {

	private String message = "Id is Not Found";

	@Override
	public String getMessage() {
		return message;

	}

	public Menu1NotFoundException(String message) {
		super();
		this.message = message;
	}

}
