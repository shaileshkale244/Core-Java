package com.app.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Map;

import com.app.cms.Customer;

public interface IOUtils {

	// storing the Map data in file
	static void storeCustomerDetails(Map<String, Customer> customer, String fname)
			throws FileNotFoundException, IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fname));) {
			out.writeObject(customer);
		}
	}

	// getting the Map data from file
	@SuppressWarnings("unchecked")
	static Map<String, Customer> getStoredCustomers(String fname) throws IOException, ClassNotFoundException
	{
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fname))) {
			Map<String, Customer> custmoers = (Map<String, Customer>) in.readObject();
			int lastId = custmoers.values().stream().sorted(Comparator.comparing(Customer::getCustid).reversed())
					.findFirst().get().getCustid();
			Customer.setCounter(++lastId);
			return custmoers;
		}		
	}
}
