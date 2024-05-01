package com.app.tester;

//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import static com.app.utils.CustomerValidation.*;
import static com.app.utils.CustmerSignupValidation.*;
import static com.app.utils.CustomerOperationUtilities.*;
import com.app.cms.Customer;

public class Test {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			// List<Customer> customer = new ArrayList<>();
			List<Customer> customer = populate();
			Customer cust = null;
			boolean exit = false;
			while (!exit) {
				System.out.println("\n\t Customer Management System");
				System.out.println(
						"1.SignUp \n2.SignIn \n3.Change Password \n4.Unsubscribe \n5.Display All Customers \n6.Display Planwise Subscribers \n7.Display Sorted List(Registration Amount Wise) \n0.Exit");
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
						for (Customer c : customer)
							System.out.println(c);
						break;
					case 6:
						System.out.println("Enter Plan Name:");
						displayDetailsPlanWise(sc.next(), customer);
						break;
					case 7:
						displaySortedDetails(customer);
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
