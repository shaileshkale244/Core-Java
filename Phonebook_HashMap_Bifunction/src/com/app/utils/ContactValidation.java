package com.app.utils;

import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Set;
import java.util.Map;
import java.util.function.BiFunction;

import com.app.core.Contact;
import com.app.custom_exception.PhonebookException;

public class ContactValidation {

	public static Contact validateInputs(String name, String phoneNumber, String email, String dateOfBirth,
			Map<String, Contact> contacts, BiFunction<String, LocalDate, String> keyContact)
			throws PhonebookException {
		isValidEmail(email);
		isValidPhoneNumber(phoneNumber);
		LocalDate dob = convertDate(dateOfBirth);
		validateUID(name, dob, contacts,keyContact);
		return new Contact(name, phoneNumber, email, dob);

	}

//converting the date
	public static LocalDate convertDate(String date) throws PhonebookException {
		try {
			return LocalDate.parse(date);
		} catch (Exception e) {
			throw new PhonebookException("Enter date in correct format: yyyy-MM-dd");
		}
	}

//validating the unique UID (name+DOB) for throwing Exception
	public static void validateUID(String name, LocalDate dob, Map<String, Contact> contacts,BiFunction<String, LocalDate, String> keyContact)
			throws PhonebookException {
		String key = keyContact.apply(name,dob);
		if (contacts.containsKey(key))
			throw new PhonebookException("Contact Already Exist!!");
	}

//validating the phone number format
	public static void isValidPhoneNumber(String phoneNumber) throws PhonebookException {
		if (!phoneNumber.matches("[1-9][0-9]{9}"))
			throw new PhonebookException("Invalid PhoneNumber . Please Enter a valid PhoneNumber !!");

	}

//validating email format
	public static void isValidEmail(String email) throws PhonebookException {
		if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:com|org|net)$"))
			throw new PhonebookException("Invalid email format. Please enter a valid email address.");
	}

}
