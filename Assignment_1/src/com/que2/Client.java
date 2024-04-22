package com.que2;

public class Client {

	public static void main(String[] args) {
		
		int arr1[][]= {{1,2},{4,5}};
		int arr2[][]= {{6,7},{8,9}};
		
		Entity e1 = new Entity();
		e1.add(arr1, arr2);
		e1.sub(arr2, arr1);

	}

}
