package brickbuster.movieRentalsApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String commissionLevel;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	

}
