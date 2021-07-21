package edu.miu.cs.cs544.examples;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppCar {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Car.class));
	}


	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		
		// Create 3 cars and save them to database
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			System.out.println("\n------------------------Creating Cars------------------------------");
			// Create new instance of Car and set values in it			
			Car car1 = new Car("Ferrari", LocalDate.parse("2020-01-01"), 280000);
			Car car2 = new Car("Bugati Chiron", LocalDate.parse("2019-01-01"), 1200000);
			Car car3 = new Car("Rols Roys", LocalDate.parse("2021-01-01"), 354000);
			
			//save car
			session.persist(car1);
			session.persist(car2);
			session.persist(car3);

			tx.commit();
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		System.out.println("\n------------------------Retrieving all the Cars------------------------------");
		// Retrieve all cars and Output to the console 
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve all Cars
			List<Car> CarList = session.createQuery("from Car", Car.class).list();
			for (Car c : CarList) {
				System.out.println(c);
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		

	}

}
