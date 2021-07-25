package edu.miu.cs.cs544.examples.b;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Getter @Setter 
@ToString
public class Passenger {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String passengerId;
	private String name;
	
	@OneToMany(cascade={CascadeType.PERSIST})
	@JoinColumn(name="customer_id")
	private List<Flight> flights = new ArrayList<>();

	public Passenger(String passengerId, String name) {
		this.passengerId = passengerId;
		this.name = name;
	}
	
	public void addFlight(Flight flight) {
		flights.add(flight);
	}

}
