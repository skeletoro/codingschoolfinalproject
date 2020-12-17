package com.brickbuster.util;

public enum CommissionLevel {

	ENTRYLEVEL(.02), INTERMEDIATE(.05), SENIOR(.10);

	private double commission;

	CommissionLevel(double commission) {
		this.commission = commission;
	}

	public double getCommission() {
		return commission;
	}

}
