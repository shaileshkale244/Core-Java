package com.dsc;


public class Apple extends Fruits {

	public Apple(String name,double weight, String color,boolean fresh) {
		super(name,weight,color,fresh);
	}
	
	public String taste() {
		return "Sweet & Sour";
	}
	
	public void jam() {
		System.out.println(this.getName()+"-> Making jam!!!");
	}
}
