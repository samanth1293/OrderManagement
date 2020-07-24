package com.dbs.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	
	  @ExceptionHandler(OrderNotFoundException.class) 
	  public String  orderNotFound(final OrderNotFoundException orderNotFoundException) {
	  orderNotFoundException.printStackTrace(); 
	  return "Invalid OrderId"; }
	  
	  @ExceptionHandler(Exception.class) 
	  public String globalException(final Exception exception) { 
		  exception.printStackTrace(); 
		  return "Contact Adminstrator"; }
	 
}
