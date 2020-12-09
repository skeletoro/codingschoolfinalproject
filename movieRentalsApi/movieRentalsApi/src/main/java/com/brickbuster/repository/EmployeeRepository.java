package com.brickbuster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.brickbuster.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
