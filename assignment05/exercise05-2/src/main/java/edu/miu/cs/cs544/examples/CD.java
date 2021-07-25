package edu.miu.cs.cs544.examples;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @Getter @Setter 
public class CD extends Product {
	private String artist;

	public CD(String artist, String name, String description) {
		super(name, description);
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "CD [artist=" + artist + ", getId()=" + getId() + ", getName()=" + getName() + ", getDescription()="
				+ getDescription();
	}	
	
	
}
