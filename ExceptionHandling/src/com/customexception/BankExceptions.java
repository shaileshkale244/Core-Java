package com.customexception;

public class BankExceptions extends RuntimeException {
	public BankExceptions(String err) {
		super(err);		
	}
}
