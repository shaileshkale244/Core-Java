package com.app.cms;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Customer implements Serializable{
	private static int counter =1000;

	public int getCustid() {
		return custid;
	}

	public static void setCounter(int counter) {
		Customer.counter = counter;
	}


	private int custid;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;

	public Customer(String fname, String lname, String email, String password, double registrationAmount, LocalDate dob,
			ServicePlan plan) {
		super();
		this.custid = counter++;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
	}

	// getter setter

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRegistrationAmount() {
		return registrationAmount;
	}

	public void setRegistrationAmount(double registrationAmount) {
		this.registrationAmount = registrationAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

// overriding the toString method to display the Customer details
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", password=" + password + ", registrationAmount=" + registrationAmount + ", dob=" + dob + ", plan="
				+ plan + "]";
	}

////overriding the equals method of Object class
//	@Override
//	public boolean equals(Object o) {
//		 System.out.println("Customer equals");
//		if (o instanceof Customer) {
//			// System.out.println(this.email==((Customer) o).email);
//			return this.email.equals(((Customer) o).email);
//		}
//		return false;
//	}



}
