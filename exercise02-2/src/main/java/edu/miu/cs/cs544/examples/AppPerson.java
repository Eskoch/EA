package edu.miu.cs.cs544.examples;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppPerson {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Person.class));
	}

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;
		
		// Create 3 persons and save them to database
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			System.out.println("\n------------------------Creating 3 Persons------------------------------");
			// Create new instance of Person and set values in it			
			Person person1 = new Person("George", "Orwell", LocalDate.now());
			Person person2 = new Person("Nampoleon", "Hill", LocalDate.now());
			Person person3 = new Person("Bealu", "Girma", LocalDate.now());
			
			//save person
			session.persist(person1);
			session.persist(person2);
			session.persist(person3);

			tx.commit();
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		System.out.println("\n------------------------Retrieving all the Persons------------------------------");
		// Retrieve all persons and Output to the console 
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve all Persons
			List<Person> PersonList = session.createQuery("from Person", Person.class).list();
			for (Person p : PersonList) {
				System.out.println(p);
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		System.out.println("\n------------------------Updating person 1 and Deleting person 2------------------------------");
		// Retrieve a person from the database and change its title and price also Delete another person
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve a person with id 1
			Person p1 = (Person) session.get(Person.class, 1L);
			Person p2 = (Person) session.load(Person.class, 2L);
			p1.setFirstName("FirstName Updated");
			p1.setLastName("LastName Updated");
			
			session.delete(p2);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		System.out.println("\n------------------------Retrieving all the Persons------------------------------");
		// Retrieve all persons and Output to the console 
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve all Persons
			List<Person> PersonList = session.createQuery("from Person", Person.class).list();
			for (Person p : PersonList) {
				System.out.println(p);
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
