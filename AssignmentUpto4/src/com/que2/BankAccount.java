package com.que2;

public class BankAccount {

	private int accountid;
	private String accountholder;
	private double balance;
	private static int count=0;
	
	
	public BankAccount(int accountid,String accountholder,double balance) {
		this.accountid=accountid;
		this.accountholder=accountholder;
		this.balance=balance;
		count++; 
	}
	
	public void deposit(double amount) {
		this.balance+=amount;
	}
	
	public void withdraw(double amount) {
		this.balance-=amount;
	}
	
	public static int getAccountCount() {
		return count;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public String getAccountholder() {
		return accountholder;
	}

	public void setAccountholder(String accountholder) {
		this.accountholder = accountholder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountid=" + accountid + ", accountholder=" + accountholder + ", balance=" + balance
				+ "]";
	}
	
	public void displayAccountDetails() {
		System.out.println(this.toString());
	}
	
}
