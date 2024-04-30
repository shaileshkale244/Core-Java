package com.app.utils;

import java.time.LocalDate;

import com.app.cms.Customer;
import com.app.cms.ServicePlan;
import com.app.custom_exception.CustomerException;

public class CustomerValidation {

	public static Customer validateInputDetails(String fname, String lname, String email, String password, String plan,
			String dob, double registrationAmount, Customer[] cust) throws CustomerException {
		validateEmail(cust, email);
		

		LocalDate date = LocalDate.parse(dob);
		ServicePlan splan = validateAndParsePlan(plan);
		double charge=validateCharges(splan,registrationAmount);

		return new Customer(fname, lname, email, password, charge, date, splan);

	}

	public static ServicePlan validateAndParsePlan(String str) {
		return ServicePlan.valueOf(str.toUpperCase());
	}

	public static void validateEmail(Customer[] arr, String str) throws CustomerException {
		Customer cust = new Customer(str);
		for (Customer a : arr) {
			if (a != null && a.equals(cust))
				throw new CustomerException("Email already exist Try with new email!!");
		}
	}
	
	public static double validateCharges(ServicePlan plan, double regAmt) throws CustomerException {
		if (regAmt!=plan.getRegAmt())
			throw new CustomerException("Invalid Amount for plan!!!!!"+plan);
		return regAmt;
	}
	
}
