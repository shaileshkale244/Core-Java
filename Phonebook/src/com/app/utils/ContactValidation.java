package com.app.utils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.app.core.Contact;
import com.app.custom_exception.PhonebookException;

public class ContactValidation {

	public static Contact validateInputs(String name, String phoneNumber, String email, String dateOfBirth,
			Set<Contact> contacts) throws PhonebookException {		
		isValidEmail(email);		
		isValidPhoneNumber(phoneNumber);
		LocalDate dob = convertDate(dateOfBirth);
		return new Contact(name, phoneNumber, email, dob);

	}

//converting the date
	private static LocalDate convertDate(String date) throws PhonebookException {
		try {
			return LocalDate.parse(date);
		} catch (Exception e) {
			throw new PhonebookException("Enter date in correct format: yyyy-MM-dd");
		}
	}
//
////validating the unique UID (name+DOB) for throwing Exception
//	public static void validateUID(String name, LocalDate dob, Set<Contact> contacts) throws PhonebookException {
//		Contact contct = new Contact(name, dob);
//		for (Contact c : contacts) {
//			if (c.equals(contct))
//				throw new PhonebookException("Contact Already Exist!!");
//		}
//	}

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

	// populating the Set
	public static Set<Contact> populate() {
		Set<Contact> contacts = new HashSet<>();
		contacts.add(new Contact("AaravPatel", "1234567890", "aarav.patel@example.com", LocalDate.parse("1992-05-15")));
		contacts.add(new Contact("AashiGupta", "9876543210", "aashi.gupta@example.com", LocalDate.parse("1988-08-20")));
		contacts.add(new Contact("AyaanSingh", "5555555555", "ayaan.singh@example.com", LocalDate.parse("1980-11-10")));
		contacts.add(new Contact("AvniSharma", "9998887770", "avni.sharma@example.com", LocalDate.parse("1997-03-25")));
		contacts.add(new Contact("IshaanKhan", "3333333333", "ishaan.khan@example.com", LocalDate.parse("1985-09-30")));
		contacts.add(new Contact("KavyaReddy", "1112223333", "kavya.reddy@example.com", LocalDate.parse("1977-12-05")));
		contacts.add(new Contact("AdvikKumar", "4444444444", "advik.kumar@example.com", LocalDate.parse("1989-06-15")));
		contacts.add(new Contact("AnayaJoshi", "6666666666", "anaya.joshi@example.com", LocalDate.parse("1993-01-20")));
		contacts.add(new Contact("AaradhyaMalhotra", "7777777777", "aaradhya.malhotra@example.com",
				LocalDate.parse("1979-04-10")));
		contacts.add(new Contact("AryanBhat", "8888888888", "aryan.bhat@example.com", LocalDate.parse("1983-07-20")));
		contacts.add(new Contact("IshanviSharma", "9999999999", "ishanvi.sharma@example.com",
				LocalDate.parse("1998-02-28")));
		contacts.add(new Contact("MyraSingh", "1212121212", "myra.singh@example.com", LocalDate.parse("1974-09-15")));
		contacts.add(new Contact("ArnavKumar", "2323232323", "arnav.kumar@example.com", LocalDate.parse("1987-11-30")));
		contacts.add(
				new Contact("PrishaPatel", "3434343434", "prisha.patel@example.com", LocalDate.parse("1993-06-05")));
		contacts.add(
				new Contact("VihaanSharma", "4545454545", "vihaan.sharma@example.com", LocalDate.parse("1979-04-20")));
		return contacts;
	}

}
