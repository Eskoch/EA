package edu.miu.cs.cs544.examples;

import java.util.ArrayList;
import java.util.List;

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
@ToString(exclude="orders")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String custId;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
	private List<Orders> orders = new ArrayList<>();

	public Customer(String custId, String firstName, String lastName) {
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// convenience method
	public void addOrder(Orders order) {
		order.setCustomer(this);
		orders.add(order);
	}
	
	// convenience method
	public void removeOrder(Orders order) {
		order.setCustomer(null);
		orders.remove(order);
	}
}
