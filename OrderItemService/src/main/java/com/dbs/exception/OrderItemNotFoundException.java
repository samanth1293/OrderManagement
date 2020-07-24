package com.dbs.exception;

public class OrderItemNotFoundException  extends Exception{

	private static final long serialVersionUID = 1L;

	public OrderItemNotFoundException(String str) {
		super(str);
	}

}
