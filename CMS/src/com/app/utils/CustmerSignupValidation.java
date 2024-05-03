package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.app.cms.Customer;
import com.app.cms.ServicePlan;
import com.app.custom_exception.CustomerRegistrationException;

public class CustmerSignupValidation {

	// Validating Inputs
	public static Customer validateInputDetails(String firstName, String lastName, String email, String password,
			String plan, String dob, double registrationAmount, List<Customer> customers)
			throws CustomerRegistrationException {
		isValidEmail(email);
		validateEmailUniqueness(customers, email);
		LocalDate dateOfBirth = validateCustomerAge(LocalDate.parse(dob));
		ServicePlan servicePlan = validateAndParsePlan(plan);
		validateRegistrationCharges(servicePlan, registrationAmount);
		return new Customer(firstName, lastName, email, password, registrationAmount, dateOfBirth, servicePlan);
	}

	// validating and parsing Service plan
	public static ServicePlan validateAndParsePlan(String plan) throws CustomerRegistrationException {
		try {
			return ServicePlan.valueOf(plan.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new CustomerRegistrationException("Invalid service plan: " + plan);
		}
	}

	// Validating the email format
	public static void isValidEmail(String email) throws CustomerRegistrationException {
		if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:com|org|net)$")) {
			throw new CustomerRegistrationException("Invalid email format. Please enter a valid email address.");
		}
	}

	// validating the Unique email id insertion into list
	public static void validateEmailUniqueness(List<Customer> customers, String email)
			throws CustomerRegistrationException {
		if (customers.contains(new Customer(email)))
			throw new CustomerRegistrationException("Email already exists. Please use a different email.");
	}

	// validating the registration amount with the
	public static void validateRegistrationCharges(ServicePlan plan, double registrationAmount)
			throws CustomerRegistrationException {
		if (registrationAmount != plan.getRegAmt()) {
			throw new CustomerRegistrationException("Invalid registration amount for the selected plan: " + plan);
		}
	}

	// validating the age of customer not be minor
	public static LocalDate validateCustomerAge(LocalDate dob) throws CustomerRegistrationException {
		if (Period.between(dob, LocalDate.now()).getYears() >= 21)
			return dob;
		throw new CustomerRegistrationException("Age not valid");
	}

	// Validating the password format
	public static String validatePassword(String password) throws CustomerRegistrationException {
		if (password.matches("((?=.*\\\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})"))
			return password;
		throw new CustomerRegistrationException("Invalid Pssword. Password must:\n Contains at least one digit \r\n"
				+ "Contains at least one lowercase letter \r\n"
				+ "Contains at least one special character from the set #@$* \r\n"
				+ "Has a length between 5 and 20 characters ");
	}
}
