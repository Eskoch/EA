package edu.miu.cs.cs544.examples.a;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Getter @Setter 
@ToString(exclude="laptops")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.PERSIST)
	private Set<Laptop> laptops = new HashSet<>();
	
	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// convenience methods
	public void addLaptop(Laptop employee) {
		employee.setEmployee(this);
		laptops.add(employee);
	}
	
	// convenience methods
	public void removeLaptop(Laptop employee) {
		employee.setEmployee(null);
		laptops.remove(employee);
	}
}
