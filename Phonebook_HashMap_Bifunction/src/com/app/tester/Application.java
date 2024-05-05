package com.app.tester;

import static com.app.utils.ContactUtility.*;
import static com.app.utils.ContactValidation.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

import com.app.core.Contact;
import com.app.custom_exception.PhonebookException;

public class Application {
	public static void main(String[] args) {
		BiFunction<String, LocalDate, String> keyContact = (key1, key2) -> key1 + "_" + key2.toString();
		Map<String, Contact> contacts = populate(keyContact);
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
						// adding the contact to map
						System.out.println("Enter  name,  phoneNumber,  email,  dateOfBirth :");
						contact = validateInputs(sc.next(), sc.next(), sc.next(), sc.next(), contacts, keyContact);
						if (contacts.putIfAbsent(keyContact.apply(contact.getName(), contact.getDateOfBirth()),
								contact) != null)
							throw new PhonebookException("Contact Already Exist!");
						System.out.println("Contact Added Succesfully!!");

						break;
					case 2:
						// displaying all contacts
						for (Contact c : contacts.values())
							System.out.println(c);
						break;
					case 3:
						// displaying all contacts
						System.out.println("Enter the name and Date of Birth :");
						System.out.println(displayContact(sc.next(), sc.next(), contacts, keyContact));
						break;
					case 4:
						// displaying all sorted contacts based upon UID
						displaySortedContactList(contacts);
						break;
					case 5:
						// displaying all sorted contacts based upon UID
						displaySortedCtListPhDesc(contacts);
						break;
					case 6:
						// remove contact based upon UID
						System.out.println("Enter the name and Date of Birth :");
						deleteContact(sc.next(), sc.next(), contacts, keyContact);
						break;
					case 7:
						// removing contacts born after date
						System.out.println("Enter Date :");
						deleteContactOnCrteria(sc.next(), contacts, keyContact);
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
