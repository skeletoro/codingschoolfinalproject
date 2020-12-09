package com.brickbuster.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class VideoGame {

	private Long videoGameId;
	private String title;
	private double price;
	
	@JsonIgnore
	private Set<Rental> rentals;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getVideoGameId() {
		return videoGameId;
	}

	public void setVideoGameId(Long videoGameId) {
		this.videoGameId = videoGameId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "videoGame_rental",
	   joinColumns = @JoinColumn(name = "rentalId", referencedColumnName = "videoGameId"),
	   inverseJoinColumns = @JoinColumn(name = "videoGameId", referencedColumnName = "rentalId"))
	public Set<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}
	
	

}
