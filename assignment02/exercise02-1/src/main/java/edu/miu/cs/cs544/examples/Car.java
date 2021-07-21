package edu.miu.cs.cs544.examples;

import java.beans.Transient;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@ToString
@Table(name="myCar")
public class Car {
	public long id;
	public String brand;
	public LocalDate year;
	public double price;
	
	public Car() {
		
	}

	public Car(String brand, LocalDate year, double price) {
		super();
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}
	
	@Transient
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@Transient
	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
		this.year = year;
	}
	
	@Transient
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
