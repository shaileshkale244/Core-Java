package com.customexception;


import java.util.Scanner;

public class BankAccountUtility {
	private static int accno = 1000;

	public static void createAccount(BankAccount arr[]) {
		Scanner sc = new Scanner(System.in);
		if (BankAccount.getAccountCount() <= arr.length) {
			System.out.println("Enter account holder name ");
			String name = sc.next();
			double balance = 0;
			accno++;
			arr[BankAccount.getAccountCount()] = new BankAccount(accno, name, balance);
		}

	}

	public static void dispAllAccount(BankAccount arr[]) {
		for (int i = 0; i < BankAccount.getAccountCount(); i++) {
			System.out.println(arr[i].toString());
		}

	}

	public static void depositAmt(BankAccount arr[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account number:");
		int acc = sc.nextInt();

		for (int i = 0; i < BankAccount.getAccountCount(); i++) {
			if (acc == arr[i].getAccountid()) {
				System.out.println("Enter amount to be deposited:");
				double amt = sc.nextDouble();
				arr[i].deposit(amt);
				return;
			}
		}
		System.out.println("Account not found!");

	}

	public static void withdrawAmt(BankAccount arr[])throws BankExceptions {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account number:");
		int acc = sc.nextInt();

		for (int i = 0; i < BankAccount.getAccountCount(); i++) {
			if (acc == arr[i].getAccountid()) {
				System.out.println("Enter amount to be withdrawn:");
				double amt = sc.nextDouble();
				arr[i].withdraw(amt);
				return;
			}
		}
		System.out.println("Account not found!");
		

	}
}

