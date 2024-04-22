
package com.que1;

import java.util.Scanner;

public class One {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[]=new int[5];
		
		System.out.println("Enter elements: ");
		for(int i=0; i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
		ArrayImplement arr1 = new ArrayImplement();
		arr1.maxEle(arr);
		arr1.sumEle(arr);
		arr1.avgArr(arr);
		arr1.sort(arr);
		
		
		
		sc.close();

	}

}
