package com.hexaware.springrestjpa.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;

import com.hexaware.springrestjpa.entities.Employee;

public interface IEmployeeService {

	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public Employee getEmployeeById(Long eid);

	public String deleteEmployeeById(Long eid);

	public List<Employee> getAllEmployees();

	public List<Employee> findByEnamEmployees(String ename);

	public List<Employee> findBySalaryGreaterThan(double salary);

	public List<Employee> salaryBtw(Double min, double max);

	public int deleteByName(String ename);

}
