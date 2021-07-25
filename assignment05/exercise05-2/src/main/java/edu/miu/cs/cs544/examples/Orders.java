package edu.miu.cs.cs544.examples;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Getter @Setter 
@ToString(exclude="customer")
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private LocalDate orderDate;
	
	@ManyToOne
	@JoinColumn
	private Customer customer;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="orders_id")
	private List<OrderLine> orderLines = new ArrayList<>();
	
	public Orders(LocalDate orderDate) {
		this.orderDate = orderDate;
	}	
	
	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}
}