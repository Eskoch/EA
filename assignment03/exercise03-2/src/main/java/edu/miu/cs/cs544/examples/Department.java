package edu.miu.cs.cs544.examples;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@ToString
@Table
public class Department {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	@OneToMany
	@JoinColumn(name="employeeId")
	private List<Employee> employees = new ArrayList<Employee>();
	
	public Department() {}

	public Department(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee emp) {
		employees.add(emp);
	}
	
}
