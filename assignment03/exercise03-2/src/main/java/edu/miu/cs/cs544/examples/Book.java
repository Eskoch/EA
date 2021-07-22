package edu.miu.cs.cs544.examples;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

public class Book {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String author;
	
	@ManyToOne
	@JoinTable(name = "Book_Publisher", 
				joinColumns = { @JoinColumn(name="Book_Id")}, 
				inverseJoinColumns = { @JoinColumn(name="Publisher_Id")}
			  )
	private List<Publisher> publishers = new ArrayList<>();
	
	public Book() {}

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(List<Publisher> publishers) {
		this.publishers = publishers;
	}
	
	public void addPublisher(Publisher publisher) {
		publishers.add(publisher);
	}

}
