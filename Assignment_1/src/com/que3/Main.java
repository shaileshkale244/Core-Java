package com.que3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// Create a new bank account
		BankAccount account = new BankAccount(123456, "Shailesh", 1000.0);

		// Menu-driven interface
		while (true) {
			System.out.println("\nBank Account Management System");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Display Account Details");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter amount to deposit: ");
				double depositAmount = sc.nextDouble();
				account.deposit(depositAmount);
				break;
			case 2:
				System.out.print("Enter amount to withdraw: ");
				double withdrawAmount = sc.nextDouble();
				account.withdraw(withdrawAmount);
				break;
			case 3:
				account.checkBalance();
				break;
			case 4:
				System.out.println(account);
				break;
			case 5:
				System.out.println("Thank you!!");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
		
	}
}
