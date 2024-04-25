package com.exceptionhandling;

public class Test1 {

	public static void main(String[] args) throws NullPointerException {
		
		try {
			String str=null;
			System.out.println(str.length());
		}
		catch(Exception e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
//			System.out.println("Hi");
		}
		finally {
			System.out.println("Resolved");
		}

	}

}
