package com.enverny.request.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "EMPLOYEE_")
public class Employee {

	@Id
	@TableGenerator(name = "table", table = "sequences_", pkColumnName = "PK_NAME", valueColumnName = "PK_VALUE", initialValue = 0, allocationSize = 1)
	@GeneratedValue(generator = "table", strategy = GenerationType.TABLE)
	@Column(name = "ID_")
	private Long id;

	@Column(name = "FIRST_NAME_")
	private String firstName;
	
	@Column(name = "LAST_NAME_")
	private String lastName;
	
	@Column(name = "EMAIL_")
	private String email;
	
	@Column(name = "NUMBER_")
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
	public String fullName() {
		return firstName +" "+ lastName;
	}
	public String initials() {
		String initials = firstName.valueOf(0).toString() +"."+lastName.valueOf(0).toString();
		return initials.toUpperCase();
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(number, other.number);
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", number=" + number + "]";
	}
	
}
