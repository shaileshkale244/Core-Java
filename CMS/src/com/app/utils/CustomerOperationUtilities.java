package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.app.cms.Customer;
import com.app.cms.ServicePlan;
import com.app.custom_exception.CustomerException;

public class CustomerOperationUtilities {

	// customer sign in using the email and password
	public static Customer customerSignIn(String email, String password, List<Customer> customer)
			throws CustomerException {
		Customer cust = new Customer(email);
		try {
			if (customer.get(customer.indexOf(cust)).getPassword().equals(password))
				return customer.get(customer.indexOf(cust));
			throw new CustomerException("Incorrect Password! Please try again!");
		} catch (IndexOutOfBoundsException e) {
			throw new CustomerException("Incorrect credentials ! Please try again!!");
		}
	}

	// changing the password of customer if signed in
	public static void changePassword(Customer cust, String oldPassword, String newPassword, List<Customer> customer)
			throws CustomerException {
		try {
			if (!oldPassword.equals(newPassword)) {
				if (cust.getPassword().equals(oldPassword)) {
					customer.get(customer.indexOf(cust)).setPassword(newPassword);
					System.out.println("Password changed Successfully!");
				}
			} else {
				throw new CustomerException("New Password same as Old Password!!Try Other Password!!");
			}
		} catch (NullPointerException e) {
			throw new CustomerException(" Sign in Required!!");
		}

	}

	// unsubscribe logged in user
	public static Customer unsubscribePlan(Customer cust, List<Customer> customer) {
		return customer.remove(customer.indexOf(cust));
	}

	// unsubscribe user by email id
	public static void unsubscribeUserPlan(String email, List<Customer> customer) throws CustomerException {
		try {
			customer.remove(customer.indexOf(new Customer(email)));
		} catch (IndexOutOfBoundsException e) {
			throw new CustomerException(" Invalid customer Email !!!!");
		}
	}

	// display names of all customers having specific type of plan
	public static void displayDetailsPlanWise(String plan, List<Customer> customer) {
		System.out.println("The List of Subscribers of Plan:");
		for (Customer c : customer) {
			if (c.getPlan().name().equals(plan.toUpperCase()))
				System.out.println(c.getFname() + " " + c.getLname());
		}
	}

	// sorting the customer list
	public static void displaySortedDetails(List<Customer> customer) {
		Collections.sort(customer, Comparator.comparing(Customer::getRegistrationAmount));
		// reversed ordered list by the lastname
		// Collections.sort(customer,
		// Comparator.comparing(Customer::getLname).reversed());
		System.out.println("After Sorting Registration Amountwise:");
		for (Customer c : customer)
			System.out.println(c);
	}

	// populating the customer list
	public static List<Customer> populate() {
		List<Customer> customers = new ArrayList<>();

		customers.add(new Customer("John", "Doe", "john.doe@example.com", "Pass@word1", 1000, LocalDate.of(1990, 5, 15),
				ServicePlan.SILVER));
		customers.add(new Customer("Jane", "Smith", "jane.smith@example.com", "Pass@word2", 2000,
				LocalDate.of(1985, 8, 20), ServicePlan.GOLD));
		customers.add(new Customer("Michael", "Johnson", "michael.johnson@example.com", "Pass@word3", 5000,
				LocalDate.of(1978, 11, 10), ServicePlan.DIAMOND));
		customers.add(new Customer("Emily", "Brown", "emily.brown@example.com", "Pass@word4", 1000,
				LocalDate.of(1995, 3, 25), ServicePlan.SILVER));
		customers.add(new Customer("David", "Williams", "david.williams@example.com", "Pass@word5", 2000,
				LocalDate.of(1982, 9, 30), ServicePlan.GOLD));
		customers.add(new Customer("Sarah", "Davis", "sarah.davis@example.com", "Pass@word6", 5000,
				LocalDate.of(1976, 12, 5), ServicePlan.DIAMOND));
		customers.add(new Customer("James", "Wilson", "james.wilson@example.com", "Pass@word7", 1000,
				LocalDate.of(1988, 6, 15), ServicePlan.SILVER));
		customers.add(new Customer("Emma", "Taylor", "emma.taylor@example.com", "Pass@word8", 2000,
				LocalDate.of(1992, 1, 20), ServicePlan.GOLD));
		customers.add(new Customer("Christopher", "Martinez", "christopher.martinez@example.com", "Pass@word9", 5000,
				LocalDate.of(1980, 4, 10), ServicePlan.DIAMOND));
		customers.add(new Customer("Ashley", "Anderson", "ashley.anderson@example.com", "Pass@word10", 1000,
				LocalDate.of(1983, 7, 20), ServicePlan.SILVER));
		customers.add(new Customer("Daniel", "Thomas", "daniel.thomas@example.com", "Pass@word11", 2000,
				LocalDate.of(1998, 2, 28), ServicePlan.GOLD));
		customers.add(new Customer("Jessica", "Garcia", "jessica.garcia@example.com", "Pass@word12", 10000,
				LocalDate.of(1974, 9, 15), ServicePlan.PLATINUM));
		customers.add(new Customer("Matthew", "Hernandez", "matthew.hernandez@example.com", "Pass@word13", 1000,
				LocalDate.of(1987, 11, 30), ServicePlan.SILVER));
		customers.add(new Customer("Amanda", "Young", "amanda.young@example.com", "Pass@word14", 2000,
				LocalDate.of(1993, 6, 5), ServicePlan.GOLD));
		customers.add(new Customer("Andrew", "King", "andrew.king@example.com", "Pass@word15", 10000,
				LocalDate.of(1979, 4, 20), ServicePlan.PLATINUM));

		return customers;
	}

}
