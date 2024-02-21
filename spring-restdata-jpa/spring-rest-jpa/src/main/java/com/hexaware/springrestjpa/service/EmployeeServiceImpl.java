package com.hexaware.springrestjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.hexaware.springrestjpa.entities.Employee;
import com.hexaware.springrestjpa.repository.EmployeeRepository;

import jakarta.persistence.criteria.Order;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	EmployeeRepository repo;
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long eid) {
		
		return repo.findById(eid).orElse(null);
	}

	@Override
	public String deleteEmployeeById(Long eid) {
		repo.deleteById(eid);
		return "record deleted";
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return repo.findAll();
	}

	@Override
	public List<Employee> findByEnamEmployees(String ename) {
		
		return repo.findByEname(ename);
	}
	

	@Override
	public List<Employee> findBySalaryGreaterThan(double salary) {
		
		return repo.findBySalaryGreaterThan(salary);
	}

	@Override
	public List<Employee> salaryBtw(Double min, double max) {
		
		return repo.findEmployeeSalaryBtw(min, max);
	}

	@Override
	public int deleteByName(String ename) {
		return repo.deleteEmployeename(ename);
	}

	
	

}
