package com.lambda;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// // Menu driven program for Arithmetic operations using Lambda expression
		Scanner sc = new Scanner(System.in);

		boolean exit = false;
		while (!exit) {
			ArithAplicable a1;
			System.out.println("Menu 1. Addition 2.Subtraction 3.Multiplication 4.Division 5.Exit");
			System.out.print("Enter choice: ");
			int choice = sc.nextInt();
			System.out.println("Enter Number 1 and Number 2 :");
			switch (choice) {
			case 1:
				a1 = (num1, num2) -> num1 + num2;
				System.out.println("Addition : " + a1.calculate(sc.nextInt(), sc.nextInt()));
				break;

			case 2:
				a1 = (num1, num2) -> num1 - num2;
				System.out.println("Subtraction : " + a1.calculate(sc.nextInt(), sc.nextInt()));
				break;
			case 3:
				a1 = (num1, num2) -> num1 * num2;
				System.out.println("Multiplication : " + a1.calculate(sc.nextInt(), sc.nextInt()));
				break;
			case 4:
				a1 = (num1, num2) -> num1 / num2;
				System.out.println("Division : " + a1.calculate(sc.nextInt(), sc.nextInt()));
				break;
			case 5:
				exit = true;
				System.out.println("Thank you!!");
				return;
			default:
				System.out.println("Invalid operation!!");
			}
		}
		sc.close();
	}

}
