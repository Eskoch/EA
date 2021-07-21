package edu.miu.cs.cs544.examples;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppBook {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Book.class));
	}

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;
		
		// Create 3 books and save them to database
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			System.out.println("\n------------------------Creating 3 Books------------------------------");
			// Create new instance of Book and set values in it			
			Book book1 = new Book("1984", "12345", "George Orwell", 12.33, LocalDate.now());
			Book book2 = new Book("Think and Grow Rich", "2347628", "Nampoleon Hill", 12.33, LocalDate.now());
			Book book3 = new Book("Oromay", "12345", "Bealu Girma", 12.33, LocalDate.now());
			
			//save book
			session.persist(book1);
			session.persist(book2);
			session.persist(book3);

			tx.commit();
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		System.out.println("\n------------------------Retrieving all the Books------------------------------");
		// Retrieve all books and Output to the console 
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve all Books
			List<Book> BookList = session.createQuery("from Book", Book.class).list();
			for (Book b : BookList) {
				System.out.println(b);
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		System.out.println("\n------------------------Updating book 1 and Deleting book 2------------------------------");
		// Retrieve a book from the database and change its title and price also Delete another book
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve a book with id 1
			Book b1 = (Book) session.get(Book.class, 1L);
			Book b2 = (Book) session.load(Book.class, 2L);
			b1.setTitle("1918 Updated");
			b1.setPrice(9.99);
			
			session.delete(b2);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		System.out.println("\n------------------------Retrieving all the Books------------------------------");
		// Retrieve all books and Output to the console 
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve all Books
			List<Book> BookList = session.createQuery("from Book", Book.class).list();
			for (Book b : BookList) {
				System.out.println(b);
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		
		// Close the SessionFactory (not mandatory)
		sessionFactory.close();
	}
}