package com.app.tester;

//import static com.app.utils.CustomerValidation.*;
import static com.app.utils.CustmerSignupValidation.validateInputDetails;
import static com.app.utils.CustomerOperationUtilities.changePassword;
import static com.app.utils.CustomerOperationUtilities.customerSignIn;
import static com.app.utils.CustomerOperationUtilities.displayDetailsPlanWise;
import static com.app.utils.CustomerOperationUtilities.populate;
import static com.app.utils.CustomerOperationUtilities.*;
import static com.app.utils.CustomerOperationUtilities.unsubscribeUserPlan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.cms.Customer;
//import com.app.custom_exception.CustomerException;
import com.app.custom_exception.CustomerRegistrationException;
import com.app.custom_ordering.DateOfBirthAndLastNameOrder;

public class Test {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			Map<String, Customer> customer = populate();
			Customer cust = null;
			boolean exit = false;
			while (!exit) {
				System.out.println("\n\t Customer Management System");
				System.out.println("1.SignUp \n2.SignIn \n3.Change Password \n4.Unsubscribe "
						+ "\n5.Display All Customers \n6.Display Planwise Subscribers "
						+ "\n7.Display Sorted List(Natural Sorting Email) " + "\n8.Display sorted List(dob n lname)"
						+ "\n9.Remove customers from specified plan n born after specified date" + "\n0.Exit");
				System.out.println("Enter choice");

				try {
					switch (sc.nextInt()) {
					case 1:

						System.out.println(
								"firstName, lastName, email, password, servicePlan, dateOfBirth, registrationAmount");

						cust = (validateInputDetails(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), customer));
						if (customer.putIfAbsent(cust.getEmail(), cust) != null)
						throw new CustomerRegistrationException("Customer Already Exist!!");
						System.out.println("Customer Added!!!");
						break;
					case 2:
						System.out.println("Enter Email And Password :");
						cust = customerSignIn(sc.next(), sc.next(), customer);
						System.out.println("Login Successful!!");
						break;
					case 3:
						if (cust != null) {
							System.out.println("Enter Old Password :");
							String oldpass = sc.next();
							System.out.println("Enter New Password :");
							String newpass = sc.next();
							changePassword(cust, oldpass, newpass, customer);
						}
						break;
					case 4:
						if (cust != null) {

							// System.out.println("Unsubscribed : "+unsubscribePlan(cust,customer));
							System.out.println("Enter Email to unsubscribe Customer:");
							unsubscribeUserPlan(sc.next(), customer);
						}
						break;
					case 5:
						for (Customer c : customer.values())
							System.out.println(c);
						break;
					case 6:
						System.out.println("Enter Plan Name:");
						displayDetailsPlanWise(sc.next(), customer);
						break;
					case 7:
						Map<String, Customer> sortedMap= new TreeMap<>(customer);
						for (Customer c : sortedMap.values())
							System.out.println(c);
						break;
					case 8:
						
						List<Customer> customers = new ArrayList<Customer>(customer.values());
						//anonymous class
//						Collections.sort(customers, new Comparator<Customer>() {
//
//							@Override
//							public int compare(Customer o1, Customer o2) {
//								if(o1.getDob().compareTo(o2.getDob())==0) {
//									return o1.getLname().compareTo(o2.getLname());
//								}
//								return o1.getDob().compareTo(o2.getDob());
//							}
//						}.reversed());
						
						   
						Collections.sort(customers, new DateOfBirthAndLastNameOrder().reversed());
						for (Customer c : customers)
							System.out.println(c);
						break;
					case 9:
						
						System.out.println("Enter date and plan");
						 removeCustomerFromPlanBornAfterDate(sc.next(), sc.next(), customer);
						break;
					case 0:
						System.out.println("Thank you");
						exit = true;
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					sc.nextLine();
				}
			}
		}

	}

}
