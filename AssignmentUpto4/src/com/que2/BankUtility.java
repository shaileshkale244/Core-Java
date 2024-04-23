package com.que2;

import java.util.Scanner;

public class BankUtility {
	
	private static int accno = 1000;
	public static void createAccount(BankAccount arr[]) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<arr.length;i++) {
		
		System.out.println("How many account you want to create");
		System.out.println("Enter account holder name ");
		String name = sc.next();
		double balance = 0;
		accno++;
		arr[i] = new BankAccount(accno, name, balance);
		}
	}

	public static void dispAllAccount(BankAccount arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].toString());
		}

	}

	public static void depositAmt(BankAccount arr[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account number:");
		int acc = sc.nextInt();

		for (int i = 0; i < arr.length; i++) {
			if (acc == arr[i].getAccountid()) {
				System.out.println("Enter amount to be deposited");
				double dep = sc.nextDouble();
				arr[i].deposit(dep);
			}
		}
	}
	
	public static void withdrawAmt(BankAccount arr[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account number:");
		int acc = sc.nextInt();

		for (int i = 0; i < arr.length; i++) {
			if (acc == arr[i].getAccountid()) {
				System.out.println("Enter amount to be withdrawn");
				double with = sc.nextDouble();
				arr[i].withdraw(with);
			}
		}
	}
}
