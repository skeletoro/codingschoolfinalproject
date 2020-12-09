package com.brickbuster.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member {
	
	private Long memberId;
	private String firstName;
	private String lastName;
	private String membershipLevel;
	private Set<Rental> rentals;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getmemberId() {
		return memberId;
	}

	public void setmemberId(Long memberId) {
		this.memberId = memberId;
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

	public String getMembershipLevel() {
		return membershipLevel;
	}

	public void setMembershipLevel(String membershipLevel) {
		this.membershipLevel = membershipLevel;
	}

	@OneToMany(mappedBy = "members")
	public Set<Rental> getRental() {
		return rentals;
	}

	public void setRental(Set<Rental> rentals) {
		this.rentals = rentals;
	}

}
