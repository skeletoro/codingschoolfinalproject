package com.brickbuster.entity;

import java.time.LocalDate;


import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rental {

	private Long rentalId;
	private LocalDate dateRented;
	private LocalDate dateDue;
	private double invoiceAmount;
	private Set<Movie> movies;
	private Set<VideoGame> videoGames;
	
	@JsonIgnore
	private Member members;
	
	@JsonIgnore
	private Employee employees;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getrentalId() {
		return rentalId;
	}

	public void setrentalId(Long rentalId) {
		this.rentalId = rentalId;
	}

	public LocalDate getDateRented() {
		return dateRented;
	}

	public void setDateRented(LocalDate dateRented) {
		this.dateRented = dateRented;
	}

	public LocalDate getDateDue() {
		return dateDue;
	}

	public void setDateDue(LocalDate dateDue) {
		this.dateDue = dateDue;
	}

	public double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	
	@ManyToMany(mappedBy = "rentals")
	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
	@ManyToMany(mappedBy = "rentals")
	public Set<VideoGame> getVideoGames() {
		return videoGames;
	}

	public void setVideoGames(Set<VideoGame> videoGames) {
		this.videoGames = videoGames;
	}

	@ManyToOne
	@JoinColumn(name = "memberId")
	public Member getMembers() {
		return members;
	}

	public void setMembers(Member members) {
		this.members = members;
	}
	
	@ManyToOne
	@JoinColumn(name = "employeeId")
	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}
	
	

}
