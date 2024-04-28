package com.dsc;



import java.util.Scanner;

public class FruitsUtility {
	
	public static void addFruit(Fruits [] arr,int n) {
		Scanner sc = new Scanner(System.in);
		String name = null;
		double weight = 0;
		String color = null;
		

		int i=0;
		while(i!=n ) {
			
			System.out.println("1. Add Mango 2. Add Orange 3. Add Apple 4.Exit");
			System.out.print("Enter choice :");
			int choice = sc.nextInt();
			
			if(choice!=4) {
			System.out.println("Enter name,weight,color :");
			 name=sc.next();
			 weight=sc.nextDouble();
			 color=sc.next();
			}
			
			switch (choice) {
			case 1:
				arr[i] = new Mango(name,weight,color,true);
				break;
			case 2:
				arr[i] = new Orange(name,weight,color,true);
				break;
			case 3:
				arr[i] = new Apple(name,weight,color,true);
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid Options");
				break;
			}
			i++;
		}
	}
	
//	public static Fruits addMangoDetails() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter name,weight,color :");
//		 String name=sc.next();
//		double weight=sc.nextDouble();
//		String color=sc.next();
//		Fruits f=new Mango(name,weight,color,true);
//		return f;
//	}
//	public static Fruits addOrangeDetails() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter name,weight,color :");
//		 String name=sc.next();
//		double weight=sc.nextDouble();
//		String color=sc.next();
//		Fruits f=new Orange(name,weight,color,true);
//		return f;
//	}
//	public static Fruits addAppleDetails() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter name,weight,color :");
//		 String name=sc.next();
//		double weight=sc.nextDouble();
//		String color=sc.next();
//		Fruits f=new Apple(name,weight,color,true);	
//		return f;
//	}
//	
	public static void displayAllName(Fruits[] arr) {
		System.out.println("Name of Fruits in basket : ");
		for(int i=0;i<Fruits.getCount();i++) {
			System.out.println(arr[i].getName());
		}
	}
	
	public static void displayAllFreshFruits(Fruits[] arr) {
		System.out.println("Fresh Fruits in basket : ");
		for(int i=0;i<Fruits.getCount();i++) {
			if(arr[i].isFresh()) {
				System.out.println("Name:"+arr[i].getName()+" Weight:"+arr[i].getWeight()+" Color:"+arr[i].getColor()+" Taste:"+arr[i].taste());
			}
			
		}
	}

	public static void markFruitStale(Fruits[] arr)  {
		System.out.println("Enter index of fruit");
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		
		if(index<0 && index>Fruits.getCount()) {
//			throw new BasketException("invalid basket index");
			System.out.println("Invalid Index");
		}else {
			arr[index].setFresh(false);
		}
	}

	public static void markSourFruitStale(Fruits[] arr) {
		for(int i=0; i<Fruits.getCount();i++) {
			if((arr[i].taste()).equals("Sour")) {
				arr[i].setFresh(false);
			}
		}
	}
	
	
	public static void useFruit(Fruits[] arr) {
		System.out.println("Enter index of fruit");
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		if(index<0 && index>Fruits.getCount()) {
			System.out.println("Invalid Index");
		}else {
			if(arr[index] instanceof Mango) {
				((Mango)arr[index]).pulp();
			}else if(arr[index] instanceof Orange) {
				((Orange)arr[index]).juice();
			}else if(arr[index] instanceof Apple){
				((Apple)arr[index]).jam();
			}
		}
		
	}
	
}
