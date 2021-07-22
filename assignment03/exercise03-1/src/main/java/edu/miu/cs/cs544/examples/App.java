package edu.miu.cs.cs544.examples;

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
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Owner.class,Car.class));
	}


	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		
		// Create 3 cars and save them to database
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			System.out.println("\n------------------------Creating Owners and Cars------------------------------");
			// Create new instance of Car and set values in it			
			Owner owner1 = new Owner("John", "Bolton");
			Owner owner2 = new Owner("Isac", "Newton");
			Owner owner3 = new Owner("Leonardo", "Davincci");
			
			// Create new instance of Car and set values in it			
			Car car1 = new Car("Ferrari", LocalDate.parse("2020-01-01"), 280000);
			Car car2 = new Car("Bugati Chiron", LocalDate.parse("2019-01-01"), 1200000);
			Car car3 = new Car("Rols Roys", LocalDate.parse("2021-01-01"), 354000);
			
			System.out.println("\n------------------------Saving cars------------------------------");
			//save car
			session.persist(car1);
			session.persist(car2);
			session.persist(car3);
			
			System.out.println("\n------------------------Saving owners------------------------------");
			//save owners
			session.persist(owner1);
			session.persist(owner2);
			session.persist(owner3);
			
			System.out.println("\n------------------------Adding cars to owners------------------------------");
			//add cars to owners
			owner1.addCar(car1);
			owner2.addCar(car2);
			owner3.addCar(car3);

			tx.commit();
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		System.out.println("\n------------------------Retrieving all the Cars with their owners------------------------------");
		// Retrieve all cars with the corresponding owners and Output to the console 
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve all Cars
			List<Owner> ownersList = session.createQuery("from Owner", Owner.class).list();
			for (Owner o : ownersList) {
				System.out.println(o + "\nCars List \n" + o.getCars());
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
