package edu.miu.cs.cs544.examples;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @Getter @Setter 
@SecondaryTable(
		name="Adress",
		pkJoinColumns=@PrimaryKeyJoinColumn(name="patient_id"))
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	@Column(table="Adress")
	private String street;
	@Column(table="Adress")
	private String zip;
	@Column(table="Adress")
	private String city;
	
	
	public Patient(String name, String street, String zip, String city) {
		this.name = name;
		this.street = street;
		this.zip = zip;
		this.city = city;
	}
	
	
}
