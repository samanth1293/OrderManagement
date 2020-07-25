package com.dbs.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {


	@ExceptionHandler(OrderItemNotFoundException.class) 
	public String  orderNotFound(final OrderItemNotFoundException orderNotFoundException) {
		orderNotFoundException.printStackTrace(); 
		return "Invalid OrderId"; }

	@ExceptionHandler(Exception.class) 
	public String globalException(final Exception exception) { 
		exception.printStackTrace(); 
		return "Contact Adminstrator"; }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> details =new ArrayList<String>();
		for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
			details.add(objectError.getDefaultMessage());
		}
		ErrorResponse error = new ErrorResponse("Validation Failed", details);
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}

}
