package com.ty.springBoot_foodApp.exception;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springBoot_foodApp.Config.ResponseStructure;
import com.ty.springBoot_foodApp.dto.Items;

@ControllerAdvice
public class ApllicationHandler extends ResponseEntityExceptionHandler {

	private Object object;
	
	@ExceptionHandler(UserNotFoundFoundException.class)
	public ResponseEntity<ResponseStructure<String>> UserNotFound(UserNotFoundFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("user Not FOUnd ");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> ProductNotFound(ProductIdNotFoundException exception) {
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("Product Not Found");
		return new  ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ItemsNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> ItemsNotFound(ItemsNotFoundException exception) {
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("Items Not Found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(FoodOrderNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> FoodNotFound(FoodOrderNotFoundException exception) {
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("FoodOrderId IS not found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Menu1NotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> Menu1NotFound(Menu1NotFoundException exception) {
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("MenuId IS not found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> list=ex.getAllErrors();
		HashMap<String, String> hashMap=new HashMap<>();
		for(ObjectError error:list) {
			String message=error.getDefaultMessage();
			String fieldname=((FieldError) error).getField();
			hashMap.put(fieldname, message); 
			
		}
		return new ResponseEntity<Object>(hashMap,HttpStatus.BAD_REQUEST);
	}
	
}
