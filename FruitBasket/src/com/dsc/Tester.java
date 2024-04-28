package com.dsc;


import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of fruit basket : ");
		int n = sc.nextInt();

		Fruits[] basket = new Fruits[n];

		boolean exit = false;
		
		FruitsUtility.addFruit(basket, n);
//		int i=0;
//		while(i!=n) {
//			
//			System.out.println("1. Add Mango 2. Add Orange 3. Add Apple 4.Exit");
//			System.out.print("Enter choice :");
//			int choice = sc.nextInt();
//			switch (choice) {
//			case 1:
//				basket[i] = FruitsUtility.addMangoDetails();
//				break;
//			case 2:
//				basket[i] = FruitsUtility.addOrangeDetails();
//				break;
//			case 3:
//				basket[i] = FruitsUtility.addAppleDetails();
//				break;
//			case 4:
//				break;
//			default:
//				System.out.println("Invalid Options");
//				break;
//			}
//			i++;
//		}
		while (!exit) {
			System.out.println("1. Display All Fruit name from basekt");
			System.out.println("2. Fresh fruits in basket");
			System.out.println("3. Mark fruit stale");
			System.out.println("4. Mark Sour fruit stale");
			System.out.println("5. Use fruit");
			System.out.println("6. Exit");

			System.out.println("Enter choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				FruitsUtility.displayAllName(basket);
				;
				break;
			case 2:
				FruitsUtility.displayAllFreshFruits(basket);
				break;
			case 3:
				FruitsUtility.markFruitStale(basket);
				break;
			case 4:
				FruitsUtility.markSourFruitStale(basket);
				break;
			case 5:
				FruitsUtility.useFruit(basket);
				break;
			case 6:
				System.out.println("Exiting Fruit Basket");
				exit = true;
				break;
			default:
				System.out.println("Invalid Options");
				break;
			}
		}
	}

}