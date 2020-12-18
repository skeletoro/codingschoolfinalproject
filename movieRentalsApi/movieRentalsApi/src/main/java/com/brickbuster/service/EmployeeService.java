package com.brickbuster.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brickbuster.entity.Employee;
import com.brickbuster.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private static final Logger Logger = LogManager.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository repo;

	public Employee createEmployee(Employee employee) {
		return repo.save(employee);
	}

	public Employee getEmployeeById(Long id) throws Exception {
		try {
			return repo.findById(id).get();
		} catch (Exception e) {
			Logger.error("Exception occurred while trying to retrieve employee: " + id, e);
			throw e;
		}
	}

	public Iterable<Employee> getEmployees() {
		return repo.findAll();
	}

	public void deleteEmployee(Long id) throws Exception {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			Logger.error("Exception occurred while trying to delete employee: " + id, e);
			throw new Exception("Unable to delete employee.");
		}
	}

	public Employee updateEmployee(Long id, Employee employee) throws Exception {
		Employee oldEmployee = repo.findById(id).get();
		try {
			if (employee.getFirstName() != null) {
				oldEmployee.setFirstName(employee.getFirstName());
			}

			else if (employee.getLastName() != null) {
				oldEmployee.setLastName(employee.getLastName());
			}

			else if (employee.getCommissionLevel() != null) {
				oldEmployee.setCommissionLevel(employee.getCommissionLevel());
			}
			return repo.save(oldEmployee);
		} catch (Exception e) {
			Logger.error("Exception occurred while trying to update employee: " + id, e);
			throw new Exception("Unable to update employee.");
		}
	}

}
