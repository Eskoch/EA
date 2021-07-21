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
@Table(name="myLaptop")
public class Laptop {
	public long id;
	public String brand;
	public String model;
	public LocalDate purchase_date;
	
	public Laptop() {
		
	}

	public Laptop(String brand, String model, LocalDate purchase_date) {
		super();
		this.brand = brand;
		this.model = model;
		this.purchase_date = purchase_date;
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
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}	
	
	@Transient
	public LocalDate getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(LocalDate purchase_date) {
		this.purchase_date = purchase_date;
	}
	
	@Transient
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	

}
