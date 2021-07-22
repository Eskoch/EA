package edu.miu.cs.cs544.examples;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Getter @Setter 
@ToString
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	private int employeeNumber;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="depatmentId")
	private Department works;
	
	@ManyToOne
	@JoinColumn(name="Office_Id")
	private Office office;
	
	public Employee(int employeeNumber, String name) {
		this.employeeNumber = employeeNumber;
		this.name = name;
	}
	
}
