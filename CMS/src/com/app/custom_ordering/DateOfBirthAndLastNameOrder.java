package com.app.custom_ordering;

import java.util.Comparator;

import com.app.cms.Customer;

public class DateOfBirthAndLastNameOrder implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2){
		if (o1.getDob().compareTo(o2.getDob()) == 0) {
			return o1.getLname().compareTo(o2.getLname());
		}
		return o1.getDob().compareTo(o2.getDob());
	}

}
