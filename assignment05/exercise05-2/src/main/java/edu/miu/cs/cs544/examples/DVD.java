package edu.miu.cs.cs544.examples;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Getter @Setter 
@ToString
public class DVD extends Product {
	private String genre;

	public DVD(String genre, String name, String description) {
		super(name, description);
		this.genre = genre;
	}	
}
