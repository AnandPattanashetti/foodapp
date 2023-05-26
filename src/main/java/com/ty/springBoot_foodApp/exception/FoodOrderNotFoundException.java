package com.ty.springBoot_foodApp.exception;

public class FoodOrderNotFoundException extends RuntimeException {

	
	private  String message="FoodOrder Not Found";

	
	
	
	@Override
	public String getMessage() {
		return message;
	}




	public FoodOrderNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
