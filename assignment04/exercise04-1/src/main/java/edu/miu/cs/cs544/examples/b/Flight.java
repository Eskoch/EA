package edu.miu.cs.cs544.examples.b;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Getter @Setter 
@ToString
public class Flight {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String flightNumber;
	private String departs;
	private String arrives;
	private LocalDate date;
	
	public Flight(String flightNumber, String departs, String arrives, LocalDate date) {
		this.flightNumber = flightNumber;
		this.departs = departs;
		this.arrives = arrives;
		this.date = date;
	}
	
}
