package com.app.cms;

public enum ServicePlan {
	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000);
	
	private double amount;
	private ServicePlan(double amount) {
		this.amount=amount;
	}
	
	@Override
	public String toString() {
		return name()+":"+amount;
	}
	
	public double getRegAmt() {
		return amount;
	}
}
