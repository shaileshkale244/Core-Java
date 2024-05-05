package com.app.utils;

import static com.app.utils.ContactValidation.convertDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiFunction;

import com.app.core.Contact;
import com.app.custom_exception.PhonebookException;

public class ContactUtility {
	// display sorted list of contacts based on UID(name,DOB)
	public static void displaySortedContactList(Map<String, Contact> contacts) {
		TreeMap<String, Contact> sortedMap = new TreeMap<>(contacts);
		for (Contact c : sortedMap.values())
			System.out.println(c);
	}

	// displaying specific contact on UID based searching(name, date of birth)
	public static Contact displayContact(String name, String date, Map<String, Contact> contacts,
			BiFunction<String, LocalDate, String> keyContact) throws PhonebookException {
		String searchKey = keyContact.apply(name, convertDate(date));
		if (contacts.containsKey(searchKey))
			return contacts.get(searchKey);
		throw new PhonebookException("Contact Not Found!!!");
	}

	// display sorted list of contacts based on phone number descending
	public static void displaySortedCtListPhDesc(Map<String, Contact> contacts) {
		List<Contact> sortedList = new ArrayList<>(contacts.values());
		Collections.sort(sortedList, (s1, s2) -> s2.getPhoneNumber().compareTo(s1.getPhoneNumber()));
		sortedList.forEach(System.out::println);
	}

	// removing particular contact(UID based)
	public static Contact deleteContact(String name, String date, Map<String, Contact> contacts,
			BiFunction<String, LocalDate, String> keyContact) throws PhonebookException {
		if (contacts.containsKey(keyContact.apply(name, convertDate(date))))
			return contacts.remove(keyContact.apply(name, convertDate(date)));
		throw new PhonebookException("Contact Not Found!!!");
	}

	// removing the all contacts based on criteria(born after date)
	public static void deleteContactOnCrteria(String date, Map<String, Contact> contacts,
			BiFunction<String, LocalDate, String> keyContact) throws PhonebookException {
//lambda function for removing the entries from map
		//contacts.values().removeIf(contact -> (contact.getDateOfBirth().isAfter(LocalDate.parse(date))));

		Iterator<String> keyItr = contacts.keySet().iterator();
		while (keyItr.hasNext()) {
			Contact c = contacts.get(keyItr.next());
			if (c.getDateOfBirth().isAfter(convertDate(date)))
				keyItr.remove();
		}

	}

	// populating the Set
	public static Map<String, Contact> populate(BiFunction<String, LocalDate, String> keyContact) {
		Set<Contact> contacts = new HashSet<>();
		contacts.add(new Contact("AaravPatel", "1234567890", "aarav.patel@example.com", LocalDate.parse("1992-05-15")));
		contacts.add(new Contact("AashiGupta", "9876543210", "aashi.gupta@example.com", LocalDate.parse("1988-08-20")));
		contacts.add(new Contact("AyaanSingh", "5555555555", "ayaan.singh@example.com", LocalDate.parse("1980-11-10")));
		contacts.add(new Contact("AvniSharma", "9998887770", "avni.sharma@example.com", LocalDate.parse("1997-03-25")));
		contacts.add(new Contact("IshaanKhan", "3333333333", "ishaan.khan@example.com", LocalDate.parse("1985-09-30")));
		contacts.add(new Contact("KavyaReddy", "1112223333", "kavya.reddy@example.com", LocalDate.parse("1977-12-05")));
		contacts.add(new Contact("AdvikKumar", "4444444444", "advik.kumar@example.com", LocalDate.parse("1989-06-15")));
		contacts.add(new Contact("AnayaJoshi", "6666666666", "anaya.joshi@example.com", LocalDate.parse("1993-01-20")));
		contacts.add(new Contact("AaradhyaMalhotra", "7777777777", "aaradhya.malhotra@example.com",
				LocalDate.parse("1979-04-10")));
		contacts.add(new Contact("AryanBhat", "8888888888", "aryan.bhat@example.com", LocalDate.parse("1983-07-20")));
		contacts.add(new Contact("IshanviSharma", "9999999999", "ishanvi.sharma@example.com",
				LocalDate.parse("1998-02-28")));
		contacts.add(new Contact("MyraSingh", "1212121212", "myra.singh@example.com", LocalDate.parse("1974-09-15")));
		contacts.add(new Contact("ArnavKumar", "2323232323", "arnav.kumar@example.com", LocalDate.parse("1987-11-30")));
		contacts.add(
				new Contact("PrishaPatel", "3434343434", "prisha.patel@example.com", LocalDate.parse("1993-06-05")));
		contacts.add(
				new Contact("VihaanSharma", "4545454545", "vihaan.sharma@example.com", LocalDate.parse("1979-04-20")));
		Map<String, Contact> hashMap = new HashMap<>();
		for (Contact c : contacts)
			hashMap.put(keyContact.apply(c.getName(), c.getDateOfBirth()), c);
		return hashMap;
	}
}
