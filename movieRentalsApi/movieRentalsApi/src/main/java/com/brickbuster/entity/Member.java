package com.brickbuster.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.brickbuster.util.MembershipLevel;

@Entity
public class Member {

	private Long memberId;
	private String firstName;
	private String lastName;
	private MembershipLevel membershipLevel;
	private Set<Rental> rentals;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getmemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
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

	public MembershipLevel getMembershipLevel() {
		return membershipLevel;
	}

	public void setMembershipLevel(MembershipLevel membershipLevel) {
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
