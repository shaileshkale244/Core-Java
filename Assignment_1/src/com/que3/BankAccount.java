package com.que3;

class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    // Method to check account balance
    public void checkBalance() {
        System.out.println("Account balance: " + balance);
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "Account id:"+ this.accountNumber + " Account Holder Name :"+ this.accountHolderName + " Balance :"+ this.balance;    }
}


