package com.que2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankAccount[] accounts = new BankAccount[10]; // Array to store up to 10 bank accounts
		boolean exit = false;
		while (!exit) {
			System.out.println("Choose an option:");
			System.out.println("1. Add Account");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Display All Accounts");
			System.out.println("5. Exit");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				// Implementation to add an account
				BankUtility.createAccount(accounts);
				break;
			case 2:
				// Implementation to deposit money
				BankUtility.depositAmt(accounts);
				break;
			case 3:
				// Implementation to withdraw money
				BankUtility.withdrawAmt(accounts);
				break;
			case 4:
				// Implementation to display all accounts
				BankUtility.dispAllAccount(accounts);
				break;
			case 5:
				System.out.println("Thank you for Banking !");
				exit = true;
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
		sc.close();
	}
}
