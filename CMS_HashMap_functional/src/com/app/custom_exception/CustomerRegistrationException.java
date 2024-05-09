package com.app.custom_exception;

@SuppressWarnings("serial")
public class CustomerRegistrationException extends Exception{
	public CustomerRegistrationException(String msg) {
		super(msg);
	}
}
