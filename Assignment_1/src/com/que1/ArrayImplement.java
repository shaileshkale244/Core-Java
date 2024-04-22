package com.que1;


public class ArrayImplement {
	int sum;
	
	// Method for finding maximum element in array
	public void maxEle(int arr[]) {
		int max=arr[0];
		// Loop to find maximum element of array
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		System.out.println();
		//Print maximum element of array
		System.out.println("Max element : "+max);
	}
	
	// Method for sum of all element of array
	public void sumEle(int arr[]) {
		sum=0;
		//loop to find sum of array
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		System.out.println("Sum of array element : "+sum);
	}
	
	// Method for average of array
	public void avgArr(int arr[]) {
		float avg=(sum/arr.length);
		System.out.println("Average of array element : "+avg);
	}
	
	
	// Method for sorting array
	public void sort(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
		}
		
		System.out.println("After sort :");
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
}
