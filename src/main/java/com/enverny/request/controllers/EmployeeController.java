package com.enverny.request.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enverny.request.entities.Employee;
import com.enverny.request.resttemplate.HttpMethods;
import com.enverny.request.services.EmployeeService;
import com.enverny.request.valueObjects.EmployeeVO;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired 
	private HttpMethods httpMethods;
	
	@PostMapping("/employee")
	public Employee newEmployee(@RequestBody Employee employee) {
		return employeeService.persistEmployee(employee);
	}
	
	@PostMapping("/newEmployee")
	public void setEmployee(@RequestBody EmployeeVO vo) {
		
		Employee employee = new Employee();
		employee.setEmail(vo.getEmail());
		employee.setFirstName(vo.getFirstName());
		employee.setLastName(vo.getLastName());
		employee.setNumber(vo.getNumber());
		
		httpMethods.HttpPostEntity("http://localhost:9889/employees/employee", employee);
	}
	
	@PutMapping("/employee/{id}")
	public Employee replaceEmployee(@RequestBody EmployeeVO vo, @PathVariable Long id) {
		Employee updateEmployee = employeeService.findById(id);
		if(vo.getEmail() != null) {
			updateEmployee.setEmail(vo.getEmail());
		}
		if(vo.getFirstName() != null) {
			updateEmployee.setFirstName(vo.getFirstName());
		}
		if(vo.getLastName() != null) {
			updateEmployee.setLastName(vo.getLastName());
		}		
		if(vo.getNumber() != null) {
			updateEmployee.setNumber(vo.getNumber());
		}
		return employeeService.persistEmployee(updateEmployee);
	}
	
	@GetMapping("/getemployees")
	public List<Employee> getEmployeeList(){
		return employeeService.findAll();
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteById(id);
	}
	
	@GetMapping("/getemployee/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}
}
