package com.brickbuster.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brickbuster.entity.Rental;
import com.brickbuster.service.RentalService;
import com.brickbuster.util.RentalStatus;

@RestController
@RequestMapping("members/{id}/rentals")
public class RentalController {

	@Autowired
	private RentalService service;
	
	@RequestMapping(value = "/movies", method = RequestMethod.POST)
	public ResponseEntity<Object> createNewMovieRental(@RequestBody Set<Long> movieIds, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.submitNewMovieRental(movieIds, id), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/videogames", method = RequestMethod.POST)
	public ResponseEntity<Object> createNewVideoGameRental(@RequestBody Set<Long> videoGameIds, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.submitNewVideoGameRental(videoGameIds, id), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getRentalsbyMember() {
		return new ResponseEntity<Object>(service.getRentals(), HttpStatus.OK);
	}
	


//	@RequestMapping(value = "/{rentalId}", method = RequestMethod.PUT)
//	public ResponseEntity<Object> UpdateRental(@RequestBody Rental rental, @PathVariable Long rentalId) {
//		try {
//			if (rental.getStatus().equals(RentalStatus.RETURNED)) {
//				return new ResponseEntity<Object>(service.cancelMovieRental(rentalId), HttpStatus.OK);
//			} else if (rental.getStatus().equals(RentalStatus.RENTED)) {
//				return new ResponseEntity<Object>(service.completeRental(rentalId), HttpStatus.OK);
//			} else if (rental.getStatus().equals(RentalStatus.RETURNED)) {
//				return new ResponseEntity<Object>(service.cancelVideoGameRental(rentalId), HttpStatus.OK);
//			} else if (rental.getStatus().equals(RentalStatus.RENTED)) {
//				return new ResponseEntity<Object>("Invalid update request.", HttpStatus.BAD_REQUEST);
//			}
//		} catch (Exception e) {
//			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
//
//		}
//		return null;
//	}
}
