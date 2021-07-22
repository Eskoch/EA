package edu.miu.cs.cs544.examples;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class Customer {
	@Id
	@GeneratedValue
	private long id;
	private String customerId;
	private String name;
	
	@OneToMany(cascade={CascadeType.PERSIST})
	@JoinColumn(name="Reservation_Id")
	private List<Reservation> reservations = new ArrayList<>();

	public Customer(String customerId, String name) {
		this.customerId = customerId;
		this.name = name;
	}
	
	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}

}
