package edu.miu.cs.cs544.examples;

import java.beans.Transient;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@ToString
@Table(name="myPerson")
public class Person {
	private long id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	
	public Person() {
		
	}

	public Person(String firstName, String lastName, LocalDate dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}
	
	@Transient
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Transient
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Transient
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
