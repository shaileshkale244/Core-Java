package com.app.custom_exception;

@SuppressWarnings("serial")
public class CustomerException extends Exception{
	public CustomerException(String msg) {
		super(msg);
	}
}
