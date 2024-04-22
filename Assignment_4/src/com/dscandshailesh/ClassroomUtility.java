package com.dscandshailesh;

import java.util.Scanner;

public class ClassroomUtility {

	public static void acceptClassroomDetails(Classroom[] classarr) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < classarr.length; i++) {
			System.out.print("Enter roomid : ");
			int roomid = sc.nextInt();
			System.out.println();
			System.out.print("Enter roomname : ");
			String rname = sc.next();
			System.out.println();
			System.out.print("Enter Teacher id :");
			int teacherid = sc.nextInt();
			System.out.println();
			System.out.println("Enter Teacher name :");
			String name = sc.next();
			System.out.println();
			System.out.println("Select Designation : 1. Professor 2. Assistant Professor");
			int desg = sc.nextInt();
			Designation post = null;
			switch (desg) {
			case 1:
				post = Designation.PROFESSOR;
				break;
			case 2:
				post = Designation.ASSISTANTPROFESSOR;
				break;
			default:
				System.out.println("Invalid choice");
			}

			classarr[i] = new Classroom(roomid, rname, new Teacher(teacherid, name, post));

		}
		sc.close();
	}
	
	public static void displayAllClassroomDetails(Classroom [] classarr) {
		for(int i=0; i<classarr.length; i++) {
			System.out.println(classarr[i].toString());
		}
	}
}
