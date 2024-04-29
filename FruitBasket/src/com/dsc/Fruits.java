package com.dsc;


abstract public class Fruits {

	private String color;
	private double weight;
	private String name;
	private boolean fresh;
	private static int count =0;
	
	public Fruits(String name,double weight, String color,boolean fresh) {
		this.name=name;
		this.weight=weight;
		this.color=color;
		this.fresh=fresh;
		count++;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFresh() {
		return fresh;
	}

	public void setFresh(boolean fresh) {
		this.fresh = fresh;
	}

	abstract public String taste();
	
	@Override
	public String toString() {
		return "Name:"+this.name+" Weight:"+this.weight+" Color:"+this.color+" fresh:"+this.fresh;
	}
	
	public static int getCount() {
		return count;
	}
	
	
}