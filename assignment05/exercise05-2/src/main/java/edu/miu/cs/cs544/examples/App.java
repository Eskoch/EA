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
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Customer.class,Orders.class,OrderLine.class,Product.class,
				CD.class,DVD.class,Book.class));
	}

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		
		// Create new entries and save them to database
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			System.out.println("\n------------------------Creating data------------------------------");			
			// Create new instance of Customer and set values in it
			Customer customer1 = new Customer("1", "Haile", "Gebre Silasie");
			Customer customer2 = new Customer("2", "Abebe", "Bikila");
			Customer customer3 = new Customer("3", "Kenenisa", "Bekele");
			
			Orders order1 = new Orders(LocalDate.now());
			Orders order2 = new Orders(LocalDate.now());
			Orders order3 = new Orders(LocalDate.now());
			
			OrderLine orderLine1 = new OrderLine(4);
			OrderLine orderLine2 = new OrderLine(7);
			OrderLine orderLine3 = new OrderLine(15);
			OrderLine orderLine4 = new OrderLine(12);
			
			Product product1 = new Product("Kirar", "It is made in Ethiopia");
			
			Product product3 = new CD("The Weeknd", "The Weeknd Music Album", "The Weeknd Music Released in 2021");
			Product product4 = new DVD("Teddy Afro", "Teddy Afro Music Video", "Teddy Afro sings about Abay");
			Product product5 = new Book("1984", "1984 Book", "1984 is written by George Orwell");
			
			//adding products to order line
			orderLine1.setProduct(product1);
			orderLine2.setProduct(product3);
			orderLine3.setProduct(product4);
			orderLine4.setProduct(product5);
			
			//adding order lines to order
			order1.addOrderLine(orderLine1);
			order2.addOrderLine(orderLine2);
			order2.addOrderLine(orderLine3);
			order3.addOrderLine(orderLine4);
			
			//setting orders to customer
			customer1.addOrder(order1);
			customer1.addOrder(order2);
			customer3.addOrder(order3);
		
			System.out.println("\n------------------------Saving data------------------------------");
			//save customer
			session.persist(customer1);
			session.persist(customer2);
			session.persist(customer3);
			
			tx.commit();
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		System.out.println("\n------------------------Retrieving data------------------------------");
		// Retrieve all cars with the corresponding owners and Output to the console 
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve data			
			List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
			for (Customer c : customers) {
				System.out.println("\n" + c + "\n");
				for(Orders o : c.getOrders()) {
					System.out.println("\n------------------------" + c.getFirstName() + " Orders------------------------------");
					System.out.println(o + "\n");
				}
				System.out.println();
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
