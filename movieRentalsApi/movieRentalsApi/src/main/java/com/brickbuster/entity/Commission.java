package com.brickbuster.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commission {

	private Long commissionId;
	private Long employeeId;
	private double commissionAmt;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCommissionId() {
		return commissionId;
	}

	public void setCommissionId(Long commissionId) {
		this.commissionId = commissionId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public double getCommissionAmt() {
		return commissionAmt;
	}

	public void setCommissionAmt(double commissionAmt) {
		this.commissionAmt = commissionAmt;
	}

}
