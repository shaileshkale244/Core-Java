package com.app.core;

import java.time.LocalDate;

public class KeyContact {
	private String name;
	private LocalDate dateOfBirth;

	public KeyContact(String name, LocalDate dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public KeyContact(Contact contact) {
		this.name = contact.getName();
		this.dateOfBirth = contact.getDateOfBirth();
	}

//overriding hashCode method
	@Override
	public int hashCode() {
		System.out.println("hash");
		return (name+dateOfBirth.toString()).hashCode() * 23;
	}

//overriding the equals method
	@Override
	public boolean equals(Object obj) {
		System.out.println("equal");
		if (obj instanceof KeyContact) {
			KeyContact other = (KeyContact) obj;
			return this.name.equals(other.name) && this.dateOfBirth.equals(other.dateOfBirth);

		}
		return false;

	}

}
