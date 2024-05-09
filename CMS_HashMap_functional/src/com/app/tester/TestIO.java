package com.app.tester;

import static com.app.utils.IOUtils.*;
import static com.app.utils.CustmerSignupValidation.validateInputDetails;
import static com.app.utils.CustomerOperationUtilities.changePassword;
import static com.app.utils.CustomerOperationUtilities.customerSignIn;
//import static com.app.utils.CustomerOperationUtilities.displayDetailsPlanWise;
//import static com.app.utils.CustomerOperationUtilities.populate;
import static com.app.utils.CustomerOperationUtilities.*;
import static com.app.utils.CustomerOperationUtilities.unsubscribeUserPlan;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
//import java.util.TreeMap;

import com.app.cms.Customer;
//import com.app.custom_exception.CustomerException;
import com.app.custom_exception.CustomerRegistrationException;

public class TestIO {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
//			Map<String, Customer> customer = populate();
			Map<String, Customer> customer = getStoredCustomers("customer.ser");
			Customer cust = null;
			boolean exit = false;
			while (!exit) {
				System.out.println("\n\t Customer Management System");
				System.out.println("1.SignUp \n2.SignIn \n3.Change Password \n4.Unsubscribe "
						+ "\n5.Display All Customers \n6.Store the Customers to the file "
						+ "\n7.Display retrived Customers from file " + "\n8.Display sorted List(dob n lname)"
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
							System.out.println("Enter Email to unsubscribe Customer:");
							unsubscribeUserPlan(sc.next(), customer);
						}
						break;
					case 5:
						customer.values().stream().forEach(System.out::println);
						break;
					case 6:
						System.out.println("Enter file name: ");
						storeCustomerDetails(customer,sc.next());
						break;
					case 7:
						System.out.println("Enter file name: ");
						getStoredCustomers(sc.next()).forEach((k,v)->System.out.println(v));
						break;
					case 8:
						displaySortedDOBLnameDetails(customer);

						break;
					case 9:
						System.out.println("Enter date and plan");
						removeCustomerFromPlanBornAfterDate(sc.next(), sc.next(), customer);
						break;
					case 0:
						storeCustomerDetails(customer,"customer.ser");
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
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
