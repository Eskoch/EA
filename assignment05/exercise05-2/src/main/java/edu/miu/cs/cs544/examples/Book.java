package edu.miu.cs.cs544.examples;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Getter @Setter 
@ToString
public class Book extends Product {
	private String title;

	public Book(String title, String name, String description) {
		super(name, description);
		this.title = title;
	}	
}
