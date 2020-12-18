package com.brickbuster.repository;

import org.springframework.data.repository.CrudRepository;

import com.brickbuster.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
