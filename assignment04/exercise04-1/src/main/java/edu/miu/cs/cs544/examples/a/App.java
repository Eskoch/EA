package edu.miu.cs.cs544.examples.a;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Employee.class,Laptop.class));
	}

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		
		// Create 3 employees and save them to database
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			System.out.println("\n------------------------Creating data------------------------------");
			// Create new instance of Employee and set values in it			
			Employee employee1 = new Employee("Robert", "Diniro");
			Employee employee2 = new Employee("Tom", "Cruise");
			Employee employee3 = new Employee("Christopher", "Nolan");
			
			// Create new instance of Employee and set values in it			
			Laptop MacBookPro = new Laptop("Apple", "Pro");
			Laptop Dell = new Laptop("Dell", "XPS15");
			Laptop Lenevo = new Laptop("Lenevo", "ThinkPad");
			
			employee1.addLaptop(MacBookPro);
			employee2.addLaptop(Dell);
			employee3.addLaptop(Lenevo);
			
			System.out.println("\n------------------------Saving data------------------------------");
			
			//save employee
			session.persist(employee1);
			session.persist(employee2);
			session.persist(employee3);
			
			tx.commit();
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		System.out.println("\n------------------------Retrieving all the Employees with their owners------------------------------");
		// Retrieve all employees with the corresponding owners and Output to the console 
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve all Employees
			List<Employee> employeeList = session.createQuery("from Employee", Employee.class).list();
			for (Employee e : employeeList) {
				System.out.println("\n" + e + "\n");
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
