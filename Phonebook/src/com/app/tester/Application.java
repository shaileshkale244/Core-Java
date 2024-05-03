package com.app.tester;

//import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import static com.app.utils.ContactValidation.*;

import com.app.core.Contact;
import com.app.custom_exception.PhonebookException;

public class Application {
	public static void main(String[] args) {
		// Set<Contact> contacts = new HashSet<>();
		Set<Contact> contacts = populate();
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			while (!exit) {
				System.out.println("--*Phonebook Application*--");
				System.out.println("1.Add Contact\n2.Display all Contacts\n0.Exit");
				System.out.println("Enter option: ");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter  name,  phoneNumber,  email,  dateOfBirth :");
						if (!contacts.add(validateInputs(sc.next(), sc.next(), sc.next(), sc.next(), contacts)))
							throw new PhonebookException("Contact Already Exist!");
						System.out.println("Contact Added Succesfully!!");

						break;
					case 2:
						for (Contact c : contacts)
							System.out.println(c);
						// displayAllContact(contacts);

						break;
					case 0:
						exit = true;

						break;

					default:

						break;
					}
				} catch (Exception e) {
					System.out.println(e);
					sc.nextLine();

				}
			}
		}
	}
}
