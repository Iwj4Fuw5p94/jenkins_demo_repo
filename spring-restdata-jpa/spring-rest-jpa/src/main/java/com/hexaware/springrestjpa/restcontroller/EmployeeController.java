package com.hexaware.springrestjpa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.springrestjpa.entities.Employee;
import com.hexaware.springrestjpa.service.IEmployeeService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/employees")
//@Valid
public class EmployeeController {
	@Autowired
	IEmployeeService service;

	@PostMapping("/add")
	public Employee insertEMployee(@RequestBody Employee employee) {

		return service.addEmployee(employee);
	}

	@PutMapping("/update")
	public Employee updEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);

	}

	@GetMapping("/get{eid}")
	public Employee getEmployeeById(@PathVariable Long eid) {
		return service.getEmployeeById(eid);
	}

	@DeleteMapping("/delete{eid}")
	public String deleteEmployee(@PathVariable Long eid) {
		return service.deleteEmployeeById(eid);

	}

	@GetMapping("/getall")
	public List<Employee> getAllEmployee() {
		return service.getAllEmployees();

	}

	@GetMapping("/getbyname/{ename}")
	public List<Employee> getByName(@PathVariable String ename) {
		return service.findByEnamEmployees(ename);
	}

	@GetMapping("/getsalary{salary}")
	public List<Employee> getBySalary(@PathVariable Double salary) {
		return service.findBySalaryGreaterThan(salary);
	}

	@GetMapping("/findSalary{min}/{max}")
	public List<Employee> findSalaryBetweenEmployeesRange(@PathVariable double min, @PathVariable double max) {
		return service.salaryBtw(min, max);
	}

	@DeleteMapping("/deletename/{ename}")
	public String delete(@PathVariable String ename) {
		int count= service.deleteByName(ename);
		return count+"recorde deleted";
	}

}
