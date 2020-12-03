package brickbuster.movieRentalsApi.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rental {

	private Long rentalId;
	private LocalDate dateRented;
	private LocalDate dateDue;
	private double invoiceAmount;
	
	@JsonIgnore
	private Set<Movie> movies;
	
	@JsonIgnore
	private Set<VideoGame> videoGames;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public Set<VideoGame> getVideoGames() {
		return videoGames;
	}

	public void setVideoGames(Set<VideoGame> videoGames) {
		this.videoGames = videoGames;
	}

}
