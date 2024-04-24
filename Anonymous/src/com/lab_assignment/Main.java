package com.lab_assignment;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Menu driven program for Arithmetic operations using anonymous class
		Scanner sc = new Scanner(System.in);
		ArithmeticOps a1 = new ArithmeticOps() {

			@Override
			public void calculate(int num1, int num2) {
				System.out.println("Addition is :" + (num1 + num2));

			}
		};
		boolean exit = false;
		while (!exit) {
			System.out.println("Menu 1. Addition 2.Subtraction 3.Multiplication 4.Division 5.Exit");
			System.out.print("Enter choice: ");
			int choice = sc.nextInt();
			System.out.println("Enter Number 1 and Number 2 :");
			switch (choice) {
			case 1:
				a1.calculate(sc.nextInt(), sc.nextInt());
				break;

			case 2:
				a1 = new ArithmeticOps() {

					@Override
					public void calculate(int num1, int num2) {
						System.out.println("Subtraction is :" + (num1 - num2));

					}
				};
				a1.calculate(sc.nextInt(), sc.nextInt());
				break;
			case 3:
				a1 = new ArithmeticOps() {

					@Override
					public void calculate(int num1, int num2) {
						System.out.println("Multiplication is :" + (num1 * num2));

					}
				};
				a1.calculate(sc.nextInt(), sc.nextInt());
				break;
			case 4:
				a1 = new ArithmeticOps() {

					@Override
					public void calculate(int num1, int num2) {
						System.out.println("Division is :" + (num1 / num2));

					}
				};
				a1.calculate(sc.nextInt(), sc.nextInt());
				break;
			case 5:
				exit = true;
				return;
			default:
				System.out.println("Invalid operation!!");
			}
		}
		sc.close();
	}

}
