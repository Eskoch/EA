package edu.miu.cs.cs544.examples;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class Reservation {
	@Id
	@GeneratedValue
	private long id;
	
	private String reservationId;
	private LocalDate reservationDate;
	
	@ManyToOne
	@JoinColumn(name="Book_Id")
	private List<Book> books = new ArrayList<>();
	
	public Reservation(String reservationId, LocalDate reservationDate) {
		this.reservationId = reservationId;
		this.reservationDate = reservationDate;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}

}
