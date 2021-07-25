package edu.miu.cs.cs544.examples.b;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Flight.class,Passenger.class));
	}

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		
		// Create 3 passengers and save them to database
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			System.out.println("\n------------------------Creating Data------------------------------");
			// Create new instance of Passenger and set values in it
			Passenger passenger1 = new Passenger("1", "John");
			Passenger passenger2 = new Passenger("2", "John");
			Passenger passenger3 = new Passenger("3", "Don");
			
			// Create new instance of Flight and set values in it
			Flight flight1 = new Flight("F1", "Las Vegas", "San Fransisco", LocalDate.now());
			Flight flight2 = new Flight("F2", "New York", "Washington DC", LocalDate.now());
			Flight flight3 = new Flight("F3", "Los Angeles", "Detroit", LocalDate.now());
			
			//save passenger
			session.persist(passenger1);
			session.persist(passenger2);
			session.persist(passenger3);
			
			//save flight
			session.persist(flight1);
			session.persist(flight2);
			session.persist(flight3);
			
			//setting flight to passengers
			passenger1.addFlight(flight1);
			passenger1.addFlight(flight2);
			passenger2.addFlight(flight3);
			
			tx.commit();
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		System.out.println("\n------------------------Retrieving Data------------------------------");
		// Retrieve all passengers with the corresponding owners and Output to the console 
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve all Passengers
			List<Passenger> passengersList = session.createQuery("from Passenger", Passenger.class).list();
			for (Passenger p : passengersList) {
				System.out.println("\n" + p + "\n");
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		sessionFactory.close();
	}
}
