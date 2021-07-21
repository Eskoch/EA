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
@Table(name="myBook")
public class Book {
	private long id;
	private String title;
	private String ISBN;
	private String author;
	private double price;
	private LocalDate publish_date;
	

	public Book(String title, String iSBN, String author, double price, LocalDate publish_date) {
		super();
		this.title = title;
		ISBN = iSBN;
		this.author = author;
		this.price = price;
		this.publish_date = publish_date;
	}
	
	public Book() {
		
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
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	@Transient
	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	@Transient
	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}

	@Transient
	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	@Transient
	public LocalDate getPublish_date() {
		return publish_date;
	}


	public void setPublish_date(LocalDate publish_date) {
		this.publish_date = publish_date;
	}
	
}
