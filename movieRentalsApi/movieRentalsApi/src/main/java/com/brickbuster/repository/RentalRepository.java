package com.brickbuster.repository;

import org.springframework.data.repository.CrudRepository;

import com.brickbuster.entity.Rental;

public interface RentalRepository extends CrudRepository<Rental, Long>{

}
