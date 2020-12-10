package com.brickbuster.util;

public enum MembershipLevel {
	
	BASIC(.00),
	GOLD(.10),
	SUPERSTAR(.15);
	
	private double discount;
	
	MembershipLevel(double discount) {
		this.discount = discount;
	}
	
	public double getDiscount() {
		return discount;
	}

}
