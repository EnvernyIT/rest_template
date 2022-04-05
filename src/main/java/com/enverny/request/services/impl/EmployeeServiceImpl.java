package com.enverny.request.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enverny.request.entities.Employee;
import com.enverny.request.repos.EmployeeRepo;
import com.enverny.request.services.EmployeeService;
import com.enverny.request.valueObjects.EmployeeVO;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee persistEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee findById(Long id) {
		 return employeeRepo.getById(id);
	}

	@Override
	public void deleteById(Long id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepo.getById(id);
	}
	
	

}
