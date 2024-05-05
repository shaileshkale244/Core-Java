package com.app.custom_exception;

@SuppressWarnings("serial")
public class PhonebookException extends Exception{
	public PhonebookException(String msg) {		
		super(msg);
	}

}
