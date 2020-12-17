package com.brickbuster.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {

	private Long employeeId;
	private String firstName;
	private String lastName;
	private String commissionLevel;
	private Set<Rental> rentals;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getemployeeId() {
		return employeeId;
	}

	public void setemployeeId(Long employeeId) {
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

	public String getCommissionLevel() {
		return commissionLevel;
	}

	public void setCommissionLevel(String commissionLevel) {
		this.commissionLevel = commissionLevel;
	}

	@OneToMany(mappedBy = "employees")
	public Set<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}

}
