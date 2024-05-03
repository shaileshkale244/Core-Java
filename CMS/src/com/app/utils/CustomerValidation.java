package com.app.utils;

import java.time.LocalDate;

import com.app.cms.Customer;
import com.app.cms.ServicePlan;
import com.app.custom_exception.CustomerRegistrationException;

public class CustomerValidation {

	public static Customer validateInputDetails(String fname, String lname, String email, String password, String plan,
			String dob, double registrationAmount, Customer[] cust) throws CustomerRegistrationException {
		validateEmail(cust, email);
		LocalDate date = LocalDate.parse(dob);
		ServicePlan splan = validateAndParsePlan(plan);
		double charge=validateCharges(splan,registrationAmount);

		return new Customer(fname, lname, email, password, charge, date, splan);

	}
//enum value validation rule
	public static ServicePlan validateAndParsePlan(String plan) throws CustomerRegistrationException{
		try {
            return ServicePlan.valueOf(plan.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new CustomerRegistrationException("Invalid service plan: " + plan);
        }
	}
//email validation for 
	public static void validateEmail(Customer[] arr, String str) throws CustomerRegistrationException {
		Customer cust = new Customer(str);
		for (Customer a : arr) {
			if (a != null && a.equals(cust))
				throw new CustomerRegistrationException("Email already exists. Please use a different email.");
		}
	}
	
	public static double validateCharges(ServicePlan plan, double regAmt) throws CustomerRegistrationException {
		if (regAmt!=plan.getRegAmt())
			throw new CustomerRegistrationException("Invalid registration amount for the selected plan: " + plan);
		return regAmt;
	}
	
}
