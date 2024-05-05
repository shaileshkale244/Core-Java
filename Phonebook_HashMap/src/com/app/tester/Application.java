package com.app.tester;

import static com.app.utils.ContactUtility.*;
import static com.app.utils.ContactValidation.validateInputs;

import java.util.Map;
//import java.util.HashSet;
import java.util.Scanner;

import com.app.core.Contact;
import com.app.core.KeyContact;
import com.app.custom_exception.PhonebookException;

public class Application {
	public static void main(String[] args) {
		// Set<Contact> contacts = new HashSet<>();
		Map<KeyContact, Contact> contacts = populate();
		Contact contact;
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			while (!exit) {
				System.out.println("--*Phonebook Application*--");
				System.out.println("1.Add Contact\n2.Display all Contacts\n0.Exit");
				System.out.println("Enter option: ");
				try {
					switch (sc.nextInt()) {
					case 1:
						//adding the contact to map
						System.out.println("Enter  name,  phoneNumber,  email,  dateOfBirth :");
						contact = validateInputs(sc.next(), sc.next(), sc.next(), sc.next(), contacts);
						if (contacts.putIfAbsent(new KeyContact(contact), contact) != null)
							throw new PhonebookException("Contact Already Exist!");
						System.out.println("Contact Added Succesfully!!");

						break;
					case 2:
						//displaying all contacts
						for (Contact c : contacts.values())
							System.out.println(c);
						break;
					case 3:
						//displaying all contacts
						System.out.println("Enter the name and Date of Birth :");
						System.out.println(displayContact(sc.next(), sc.next(), contacts));
						break;
					case 4:
						//displaying all contacts
						for (KeyContact c : contacts.keySet())
							System.out.println(c.hashCode());
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
