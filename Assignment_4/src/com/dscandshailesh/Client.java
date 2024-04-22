package com.dscandshailesh;

public class Client {

	public static void main(String[] args) {
		
		Classroom [] classarr = new Classroom[2];
		ClassroomUtility.acceptClassroomDetails(classarr);
		ClassroomUtility.displayAllClassroomDetails(classarr);

	}

}
