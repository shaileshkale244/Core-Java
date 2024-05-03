package com.app.core;

import java.time.LocalDate;


public class Contact {
	private String name;
	private String phoneNumber;
	private String email;
	private LocalDate dateOfBirth;
	
	//constructor for adding the customer
	public Contact(String name, String phoneNumber, String email, LocalDate dateOfBirth) {
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.email=email;
		this.dateOfBirth=dateOfBirth;		
	}
	
	//parameterized constructor for UID uniqueness checking
	public Contact(String name,  LocalDate dateOfBirth) {
		this.name=name;
		this.dateOfBirth=dateOfBirth;
	}
	
	//getter setter
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	//overriding the toString method
	@Override
	public String toString() {
		return "name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth;
	}
	
	//overriding the hashCode method
	@Override
	public int hashCode() {
		System.out.println("hashcode");
		return (name+dateOfBirth.toString()).hashCode();
	}
	
	//overriding the equals method
	@Override
	public boolean equals(Object obj) {
		System.out.println("equal");
		if(obj instanceof Contact) {
			Contact other = (Contact) obj;
			return this.name.equals(other.name)&& this.dateOfBirth.equals(other.dateOfBirth);
			
		}
		return false;
		
	}
	
	
	

}
