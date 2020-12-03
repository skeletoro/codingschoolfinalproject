package brickbuster.movieRentalsApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class VideoGame {

	private Long videoGameId;
	private String title;
	private double price;
	private Rental rental;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@ManyToOne
	@JoinColumn(name = "rentId")
	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

}
