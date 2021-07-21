package edu.miu.cs.cs544.examples;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppLaptop {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Laptop.class));
	}


	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		
		// Create 3 laptops and save them to database
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			System.out.println("\n------------------------Creating Laptops------------------------------");
			// Create new instance of Laptop and set values in it			
			Laptop laptop1 = new Laptop("Apple", "MacBook Pro", LocalDate.parse("2020-01-01"));
			Laptop laptop2 = new Laptop("Dell", "XPS15", LocalDate.parse("2019-01-01"));
			Laptop laptop3 = new Laptop("Lenevo", "ThinkPad", LocalDate.parse("2021-01-01"));
			
			//save laptop
			session.persist(laptop1);
			session.persist(laptop2);
			session.persist(laptop3);

			tx.commit();
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		System.out.println("\n------------------------Retrieving all the Laptops------------------------------");
		// Retrieve all laptops and Output to the console 
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve all Laptops
			List<Laptop> LaptopList = session.createQuery("from Laptop", Laptop.class).list();
			for (Laptop c : LaptopList) {
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
