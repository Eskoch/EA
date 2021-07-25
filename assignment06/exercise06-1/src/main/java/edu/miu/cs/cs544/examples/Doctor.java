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
@ToString(exclude="appointments")
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String doctorType;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy="doctor", cascade=CascadeType.PERSIST)
	private List<Appointment> appointments = new ArrayList<Appointment>();
	
	public Doctor(String doctorType, String firstName, String lastName) {
		this.doctorType = doctorType;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// convenience methods
	public void addAppointMent(Appointment appointment) {
		appointment.setDoctor(this);
		appointments.add(appointment);
	}
	
	// convenience methods
	public void removeEmployee(Appointment appointment) {
		appointment.setDoctor(null);
		appointments.remove(appointment);
	}

	
}
