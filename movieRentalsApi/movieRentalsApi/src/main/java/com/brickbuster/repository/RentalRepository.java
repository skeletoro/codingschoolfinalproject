package com.brickbuster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.brickbuster.entity.Rental;

@NoRepositoryBean
public interface RentalRepository extends CrudRepository<Rental, Long>{

}
