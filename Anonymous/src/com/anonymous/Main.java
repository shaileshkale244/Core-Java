package com.anonymous;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Anonymous of the interface
		Applicable a1 = new Applicable() {
			
			@Override
			public void display() {
				// TODO Auto-generated method stub
				System.out.println("Interface anonymous!");
				
			}			
		};
		a1.display();
		
		//anonymous of the concrete class methods
		Test t1 =new Test() {
			
			@Override
			 public void run() {
					System.out.println("This is Test Anonymous!!!");
				}
		};
		t1.run();
		//method other than overridden method
		t1.test();

	}

}
