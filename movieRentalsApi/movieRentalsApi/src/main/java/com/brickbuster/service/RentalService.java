package com.brickbuster.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brickbuster.entity.Employee;
import com.brickbuster.entity.Member;
import com.brickbuster.entity.Movie;
import com.brickbuster.entity.Rental;
import com.brickbuster.entity.VideoGame;
import com.brickbuster.repository.MemberRepository;
import com.brickbuster.repository.RentalRepository;
import com.brickbuster.repository.MovieRepository;
import com.brickbuster.repository.VideoGameRepository;

import com.brickbuster.util.RentalStatus;
import com.brickbuster.util.MembershipLevel;

@Service
public class RentalService {

	private static final Logger logger = LogManager.getLogger(RentalService.class);

	private final int DAYS_UNTIL_DUE = 7;

	@Autowired
	private RentalRepository repo;

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private VideoGameRepository videoGameRepo;

	public Rental submitNewMovieRental(Set<Long> movieId, Long memberId) throws Exception {
		try {
			Member member = memberRepo.findById(memberId).get();
			Rental rental = initializeNewMovieRental(movieId, member);
			return repo.save(rental);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to create new rental for customer: " + memberId, e);
			throw e;
		}
	}

	public Rental cancelMovieRental(Long rentalId) throws Exception {
		try {
			Rental rental = repo.findById(rentalId).get();
			rental.setStatus(RentalStatus.RETURNED);
			return repo.save(rental);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to cancel rental: " + rentalId, e);
			throw new Exception("Unable to update Rental.");
		}
	}

	private Rental initializeNewMovieRental(Set<Long> movieId, Member member) {
		Rental rental = new Rental();
		rental.setMovies(convertToMovieSet(movieRepo.findAllById(movieId)));
		rental.setDateRented(LocalDate.now());
		rental.setDateDue(LocalDate.now().plusDays(DAYS_UNTIL_DUE));
		rental.setMembers(member);
		rental.setInvoiceAmount(calculateMovieTotal(rental.getMovies(), member.getMembershipLevel()));
		rental.setStatus(RentalStatus.RENTED);
		addRentalToMovie(rental);
		return rental;
	}

	private Set<Movie> convertToMovieSet(Iterable<Movie> Id) {

		Set<Movie> set = new HashSet<Movie>();
		for (Movie movie : Id) {
			set.add(movie);
		}

		return set;
	}

	private Set<VideoGame> convertToVideoGameSet(Iterable<VideoGame> Id) {

		Set<VideoGame> set = new HashSet<VideoGame>();
		for (VideoGame videogame : Id) {
			set.add(videogame);
		}

		return set;
	}

	public Rental submitNewVideoGameRental(Set<Long> videoGameIds, Long memberId) throws Exception {
		try {
			Member member = memberRepo.findById(memberId).get();
			Rental rental = initializeNewVideoGameRental(videoGameIds, member);
			return repo.save(rental);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to create new rental for customer: " + memberId, e);
			throw e;
		}
	}

	public Rental cancelVideoGameRental(Long rentalId) throws Exception {
		try {
			Rental rental = repo.findById(rentalId).get();
			rental.setStatus(RentalStatus.RETURNED);
			return repo.save(rental);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to cancel rental: " + rentalId, e);
			throw new Exception("Unable to update Rental.");
		}
	}

	private Rental initializeNewVideoGameRental(Set<Long> videoGameIds, Member member) {

		Rental rental = new Rental();
		rental.setVideoGames(convertToVideoGameSet(videoGameRepo.findAllById(videoGameIds)));
		rental.setDateRented(LocalDate.now());
		rental.setDateDue(LocalDate.now().plusDays(DAYS_UNTIL_DUE));
		rental.setMembers(member);
		rental.setInvoiceAmount(calculateVideoGameTotal(rental.getVideoGames(), member.getMembershipLevel()));
		rental.setStatus(RentalStatus.RENTED);
		addRentalToVideoGame(rental);
		return rental;

	}

	private void addRentalToVideoGame(Rental rental) {
		Set<VideoGame> videoGames = rental.getVideoGames();
		for (VideoGame videogame : videoGames) {
			videogame.getRentals().add(rental);

		}
	}

	private void addRentalToMovie(Rental rental) {
		Set<Movie> movies = rental.getMovies();
		for (Movie movie : movies) {
			movie.getRentals().add(rental);
		}
	}

	private double calculateVideoGameTotal(Set<VideoGame> videoGames, MembershipLevel level) {
		double VGtotal = 0;
		for (VideoGame videogame : videoGames) {
			VGtotal += videogame.getPrice();
		}

		return VGtotal - VGtotal * level.getDiscount();
	}

	private double calculateMovieTotal(Set<Movie> movies, MembershipLevel level) {
		double Mtotal = 0;
		for (Movie movie : movies) {
			Mtotal += movie.getPrice();
		}

		return Mtotal - Mtotal * level.getDiscount();
	}

	public Rental returnRental(Long rentalId) throws Exception {
		try {
			Rental rental = repo.findById(rentalId).get();
			rental.setStatus(RentalStatus.RETURNED);
			return repo.save(rental);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to return rental: " + rentalId, e);
			throw new Exception("Unable to update rental.");
		}
	}

	public Iterable<Rental> getRentals() {
		return repo.findAll();
	}

	public void removeRental(Long rentalId) throws Exception {
		try {
			repo.deleteById(rentalId);

		} catch (Exception e) {
			logger.error("Exception occured while trying to delete rental: " + rentalId, e);
			throw new Exception("Unable to delete rental.");
		}

	}
}

