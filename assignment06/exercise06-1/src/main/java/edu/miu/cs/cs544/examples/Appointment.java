package edu.miu.cs.cs544.examples;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private LocalDate appDate;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn
	private Patient patient;
	
	@Embedded
	private Payment payment;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn
	private Doctor doctor;

	public Appointment(LocalDate appDate, Patient patient, Payment payment) {
		this.appDate = appDate;
		this.patient = patient;
		this.payment = payment;
	}
	
	
}
