package edu.miu.cs.cs544.examples;

import java.util.ArrayList;
import java.util.List;

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
public class Office {
	@Id
	@GeneratedValue
	private long id;
	
	private int roomNumber;
	private int building;
	
	@ManyToOne
	@JoinColumn(name="Employee_Id")
	private List<Employee> employees = new ArrayList<Employee>();
	
	public Office(int roomNumber, int building) {
		this.roomNumber = roomNumber;
		this.building = building;
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
}
