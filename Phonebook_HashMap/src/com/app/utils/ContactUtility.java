package com.app.utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.app.core.Contact;
import com.app.core.KeyContact;
import com.app.custom_exception.PhonebookException;

public class ContactUtility {
	//displaying specific contact on UID based searching(name, date of birth)
	public static Contact displayContact(String name,String date,Map<KeyContact, Contact> contacts) throws PhonebookException {
		KeyContact contact = new KeyContact(name,LocalDate.parse(date));
		if(contacts.containsKey(contact))
					return contacts.get(contact);
		throw new PhonebookException("Contact Not Found!!!");
	}
	// populating the Set
		public static Map<KeyContact,Contact> populate() {
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
			Map<KeyContact, Contact> hashMap= new HashMap<>();
			for(Contact c : contacts)
				hashMap.put(new KeyContact(c), c);
			return hashMap;
		}
}
