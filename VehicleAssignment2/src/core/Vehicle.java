package core;

import java.util.Date;

public class Vehicle {
	
	

	private String chasisNo;
	private Color color;
	private double price;
	private String manufactureDate;
	private String insuranceExpDate;
	private double pollutionLevel;
	
	private static int count=0;

	public Vehicle(String chasisNo,Color color,double price,String manufactureDate,String insuranceExpDate) {
		this.chasisNo=chasisNo;
		this.color=color;
		this.price=price;
		this.manufactureDate=manufactureDate;
		this.insuranceExpDate=insuranceExpDate;
		this.pollutionLevel=0;
		count++;
	}

	public String getChasisNo() {
		return chasisNo;
	}

	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

//	public Date getManufactureDate() {
//		return manufactureDate;
//	}
//
//	public void setManufactureDate(Date manufactureDate) {
//		this.manufactureDate = manufactureDate;
//	}
//
//	public Date getInsuranceExpDate() {
//		return insuranceExpDate;
//	}
//
//	public void setInsuranceExpDate(Date insuranceExpDate) {
//		this.insuranceExpDate = insuranceExpDate;
//	}

	public double getPollutionLevel() {
		return pollutionLevel;
	}

	public void setPollutionLevel(double pollutionLevel) {
		this.pollutionLevel = pollutionLevel;
	}

	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", color=" + color + ", price=" + price + ", manufactureDate="
				+ manufactureDate + ", insuranceExpDate=" + insuranceExpDate + ", pollutionLevel=" + pollutionLevel
				+ "]";
	}
	
	public static int getCount() {
		return count;
	}
	
	
	
	
}
