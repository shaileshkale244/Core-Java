package com.dsc;



public class Mango extends Fruits {

	public Mango(String name,double weight, String color,boolean fresh) {
		super(name,weight,color,fresh);
	}

	public String taste() {
		return "Sweet";
	}
	
	public void pulp() {
		System.out.println(this.getName()+":"+this.getColor()+" -> Creating pulp!!!");
	}
}