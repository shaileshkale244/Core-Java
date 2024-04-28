package com.dsc;


public class Orange extends Fruits{
	
	public Orange(String name,double weight, String color,boolean fresh) {
		super(name,weight,color,fresh);
	}
	
	public String taste() {
		return "Sour";
	}
	
	public void juice() {
		System.out.println(this.getName()+":"+this.getWeight()+" -> Extracting juice!!!");
	}

}
