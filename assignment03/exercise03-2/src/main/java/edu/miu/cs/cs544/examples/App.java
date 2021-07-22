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
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Department.class,Employee.class,
				Book.class,Course.class,Customer.class,Office.class,Publisher.class,Reservation.class,Student.class));
	}


	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		
		// Create 3 cars and save them to database
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			System.out.println("\n------------------------Creating data------------------------------");
			// Create new instance of Car and set values in it			
			Department airospaceDept = new Department("Airospace");
			Department materialDept = new Department("Material Science");
			Department elctricalDept = new Department("Electrical and Computer Engineering");
			
			// Create new instance of Car and set values in it			
			Employee employee1 = new Employee(1, "Alpha");
			Employee employee2 = new Employee(2, "Bravo");
			Employee employee3 = new Employee(3, "Charlie");
			
			System.out.println("\n------------------------Saving data------------------------------");
			//save car
			session.persist(airospaceDept);
			session.persist(materialDept);
			session.persist(elctricalDept);
			
			//save owners
			session.persist(employee1);
			session.persist(employee2);
			session.persist(employee3);
			
			//add cars to owners
			airospaceDept.addEmployee(employee1);
			materialDept.addEmployee(employee2);
			elctricalDept.addEmployee(employee3);
			
			
			// Create new instance of Book and set values in it			
			Book book1 = new Book("1984", "George Orwell");
			Book book2 = new Book("Think and Grow Rich", "Nampoleon Hill");
			Book book3 = new Book("Oromay", "Bealu Girma");
			
			// Create new publisher
			Publisher publisher1 = new Publisher("J and G");
			Publisher publisher2 = new Publisher("Bravo pub");
			Publisher publisher3 = new Publisher("Wilsher Co");
			
			//save book
			session.persist(book1);
			session.persist(book2);
			session.persist(book3);
			
			//save publishers
			session.persist(publisher1);
			session.persist(publisher2);
			session.persist(publisher3);
			
			// Create new instance of Student and set values in it
			Student student1 = new Student(1, "John", "Smith");
			Student student2 = new Student(1, "John", "Snow");
			Student student3 = new Student(1, "Don", "Dalton");
			
			// Create new instance of Course and set values in it
			Student course1 = new Student(1, "CS11", "EA");
			Student course2 = new Student(2, "ENG12", "SWA");
			Student course3 = new Student(3, "Math89", "Calculus");
			
			//save book
			session.persist(student1);
			session.persist(student2);
			session.persist(student3);
			
			//save course
			session.persist(course1);
			session.persist(course2);
			session.persist(course3);
			
			// Create new instance of Customer and set values in it
			Customer customer1 = new Customer("1", "John");
			Customer customer2 = new Customer("2", "John");
			Customer customer3 = new Customer("3", "Don");
			
			// Create new instance of Reservation and set values in it
			Reservation reservation1 = new Reservation("1", LocalDate.now());
			Reservation reservation2 = new Reservation("2", LocalDate.now());
			Reservation reservation3 = new Reservation("3", LocalDate.now());
			
			//save customer
			session.persist(customer1);
			session.persist(customer2);
			session.persist(customer3);
			
			//save reservation
			session.persist(reservation1);
			session.persist(reservation2);
			session.persist(reservation3);
			
			// Create new instance of Office and set values in it
			Office office1 = new Office(12, 34);
			Office office2 = new Office(23, 34);
			Office office3 = new Office(12, 33);
			
			//save customer
			session.persist(office1);
			session.persist(office2);
			session.persist(office3);
			
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
			List<Department> departmentList = session.createQuery("from Department", Department.class).list();
			for (Department d : departmentList) {
				System.out.println(d);
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
