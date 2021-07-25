package edu.miu.cs.cs544.examples.a;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Getter @Setter 
@ToString(exclude="employee")
public class Laptop {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String brand;
	private String type;
	
	@ManyToOne
	private Employee employee;
	
	public Laptop(String brand, String type) {
		this.brand = brand;
		this.type = type;
	}
}
