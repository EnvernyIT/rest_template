package com.enverny.request.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enverny.request.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	

}
