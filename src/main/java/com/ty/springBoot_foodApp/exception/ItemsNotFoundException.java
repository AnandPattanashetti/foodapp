package com.ty.springBoot_foodApp.exception;

public class ItemsNotFoundException extends RuntimeException {

	private String message="Id is Not Found";

	@Override
	public String getMessage() {
		return message;
	
	}
		public ItemsNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
