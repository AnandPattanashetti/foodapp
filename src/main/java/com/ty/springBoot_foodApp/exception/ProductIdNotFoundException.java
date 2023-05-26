package com.ty.springBoot_foodApp.exception;

public class ProductIdNotFoundException extends RuntimeException {
	
	private String message="Product Not Found Exception";

	
	
	
	
	
	
	@Override
	public String getMessage() {
		return message;
	}







	public ProductIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
	
	
}
