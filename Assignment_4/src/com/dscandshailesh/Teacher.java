package com.dscandshailesh;

public class Teacher {

	private int teacherid;
	private String name;
	private Designation designation;
	
	
	public Teacher(int teacherid,String name,Designation designation) {
		this.teacherid=teacherid;
		this.name=name;
		this.designation=designation;
	}


	@Override
	public String toString() {
		return "Teacherid=" + teacherid + ", TeacherName=" + name + ", Designation=" + designation;
	}


	public int getTeacherid() {
		return teacherid;
	}


	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Designation getDesignation() {
		return designation;
	}


	public void setDesignation(Designation designation) {
		this.designation = designation;
	}
	
	
	
	
}
