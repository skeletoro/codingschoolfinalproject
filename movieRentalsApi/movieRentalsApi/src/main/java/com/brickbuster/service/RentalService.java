package com.brickbuster.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brickbuster.entity.Member;
import com.brickbuster.entity.Rental;
import com.brickbuster.repository.MemberRepository;
import com.brickbuster.repository.RentalRepository;





public class RentalService {

	private static final Logger logger = LogManager.getLogger(RentalService.class);
	
	@Autowired
	private RentalRepository repo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	
	
	
	public Rental submitNewMovieOrder(Set<Long> movieId, Long memberId) throws Exception {
		try {
			Member member = memberRepo.findById(memberId).get();
			Rental rental = initializeNewMovieOrder(movieId, member);
			return repo.save(rental);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to create new rental for customer: "+ memberId, e);
			throw e;
		}
	}


	private Rental initializeNewMovieOrder(Set<Long> movieId, Member member) {

		return null;
	}
	
	public Rental submitNewVideoGameOrder(Set<Long> videoGameId, Long memberId) throws Exception {
		try {
			Member member = memberRepo.findById(memberId).get();
			Rental rental = initializeNewVideoGameOrder(videoGameId, member);
			return repo.save(rental);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to create new rental for customer: "+ memberId, e);
			throw e;
		}
	}


	private Rental initializeNewVideoGameOrder(Set<Long> videoGameId, Member member) {

		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
