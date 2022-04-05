package com.enverny.request.valueObjects;

import java.util.Objects;

public class EmployeeVO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String number;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, number);
	}
	public String fullName() {
		return firstName +" "+ lastName;
	}
	public String initials() {
		String initials = firstName.valueOf(0).toString() +"."+lastName.valueOf(0).toString();
		return initials.toUpperCase();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeVO other = (EmployeeVO) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(number, other.number);
	}

	
}
