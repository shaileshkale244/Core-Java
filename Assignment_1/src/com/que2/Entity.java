package com.que2;

public class Entity {
	
	// Method to find Additon of Matrix
	public void add(int arr1[][],int arr2[][]) {
		int res[][]=new int[2][2];
		for(int i=0; i<2;i++) {
			for(int j=0; j<2;j++) {
				res[i][j]=arr1[i][j]+arr2[i][j];
			}
		}
		
		System.out.println("Addition of matrix:");
		for(int i=0; i<2;i++) {
			for(int j=0; j<2;j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	// Method to find subtraction of matrix
	public void sub(int arr1[][],int arr2[][]) {
		int res[][]=new int[2][2];
		for(int i=0; i<2;i++) {
			for(int j=0; j<2;j++) {
				res[i][j]=arr1[i][j]-arr2[i][j];
			}
		}
		
		System.out.println("Subtraction of matrix:");
		for(int i=0; i<2;i++) {
			for(int j=0; j<2;j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
}
