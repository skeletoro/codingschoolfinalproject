package com.brickbuster.controller;

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
import com.nhlhockey.inventoryManagement.entity.Order;
import com.nhlhockey.inventoryManagement.util.OrderStatus;



@RestController
@RequestMapping("members/{id}/rentals")
public class RentalController {

	@Autowired
	private RentalService service;
	
	
	
	
	
	
	
	@RequestMapping(value = "/{renalId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> UpdateRental(@RequestBody Rental rental, @PathVariable Long rentalId) {
		try {
			if (rental.getStatus().equals(RentalStatus.RETURNED)) {
				return new ResponseEntity<Object>(service.cancelMovieRental(rentalId), HttpStatus.OK);
			} else if (order.getStatus().equals(OrderStatus.DELIVERED)) {
				return new ResponseEntity<Object>(service.completeOrder(orderId), HttpStatus.OK);
			}
			return new ResponseEntity<Object>("Invalid update request.", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}


