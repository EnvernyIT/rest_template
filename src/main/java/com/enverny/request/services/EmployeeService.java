package com.enverny.request.services;

import java.util.List;

import com.enverny.request.entities.Employee;
import com.enverny.request.valueObjects.EmployeeVO;

public interface EmployeeService {
	
	public Employee findById(Long id);

	public List<Employee> findAll();
	
	public Employee persistEmployee(Employee employee);
	
	public void deleteById(Long id);
	
	public Employee getEmployeeById(Long id);

}
