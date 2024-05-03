package com.app.tester;

//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import static com.app.utils.CustomerValidation.*;
import static com.app.utils.CustmerSignupValidation.*;
import static com.app.utils.CustomerOperationUtilities.*;
import com.app.cms.Customer;

public class Test2 {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			// List<Customer> customer = new ArrayList<>();
			List<Customer> customer = populate();
			Customer cust = null;
			boolean exit = false;
			while (!exit) {
				System.out.println("\n\t Customer Management System");
				System.out
						.println("1.SignUp \n2.SignIn \n3.Display Sorted listaccording to email (natural ordering)  \n"
								+ "4.Display Sorted details according to DoB And LastName \n"
								+ "5.Remove the plan customers \n0.Exit");
				System.out.println("Enter choice");

				try {
					switch (sc.nextInt()) {
					case 1:

						System.out.println(
								"firstName, lastName, email, password, servicePlan, dateOfBirth, registrationAmount");
						customer.add(validateInputDetails(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.nextDouble(), customer));
						break;
					case 2:
						System.out.println("Enter Email And Password :");
						cust = customerSignIn(sc.next(), sc.next(), customer);
						System.out.println("Login Successful!!" + cust);
						break;
					case 3:
						displaySortedEmails(customer);
						break;
					case 4:
						displaySortedOnBirthdateAndLastName(customer);
						break;
					case 5:
						System.out
								.println("Remove customers born after the selected date from the selected plan -----");
						System.out.println("Enter Plan Name And Date:");
						removeCustomerPlanAndBirthdateWise(customer, sc.next(), sc.next());
						break;
					case 6:
						displayDetails(customer);
						break;
					case 7:

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
