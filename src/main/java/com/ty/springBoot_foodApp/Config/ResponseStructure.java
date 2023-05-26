package com.ty.springBoot_foodApp.Config;

import org.springframework.http.HttpStatus;

public class ResponseStructure<T> {

	private int status;
	private String message;
	private Object data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int created) {
		this.status = created;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
