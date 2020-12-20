package com.brickbuster.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.brickbuster.util.CommissionLevel;

@Entity
public class Employee {

	private Long employeeId;
	private String firstName;
	private String lastName;
	private CommissionLevel commissionLevel;
	private Set<Rental> rentals;
	private Set<Commission> commissions;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CommissionLevel getCommissionLevel() {
		return commissionLevel;
	}

	public void setCommissionLevel(CommissionLevel commissionLevel) {
		this.commissionLevel = commissionLevel;
	}

	@OneToMany(mappedBy = "employees")
	public Set<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}

//	@OneToMany(mappedBy = "employeeId")
//	public Set<Commission> getCommissions() {
//		return commissions;
//	}
//
//	public void setCommissions(Set<Commission> commissions) {
//		this.commissions = commissions;
//	}

}
