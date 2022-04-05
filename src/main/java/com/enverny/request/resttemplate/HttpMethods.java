package com.enverny.request.resttemplate;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.enverny.request.entities.Employee;

@Component
public class HttpMethods {

	@Autowired
	RestTemplate restTemplate;

	public Employee HttpPostEntity(String URI, Employee employee) {
		Employee createdEmployee = restTemplate.postForObject(URI,  employee, Employee.class);
		return createdEmployee;
	}
	
	public void HttpPutEntity(String URI, Employee employee, Long employeeId) {
		Map<String, String> params = new HashMap<>();
		params.put("id", employeeId.toString());
		restTemplate.put(URI, employee, Employee.class);
	}

}
