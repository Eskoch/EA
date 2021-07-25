package edu.miu.cs.cs544.examples.c;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Student.class,School.class));
	}

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		
		// Create 3 schools and save them to database
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			System.out.println("\n------------------------Creating Data------------------------------");
			// Create new instance of School and set values in it
			School school1 = new School("Alpha School");
			School school2 = new School("Bravo School");
			School school3 = new School("Charlie School");
			
			// Create new instance of Student and set values in it
			Student student1 = new Student("A1", "John", "Snow");
			Student student2 = new Student("B2", "Walter", "White");
			Student student3 = new Student("C3", "Sheldon", "Chooper");
			
			//save school
			session.persist(school1);
			session.persist(school2);
			session.persist(school3);
			
			//save student
			session.persist(student1);
			session.persist(student2);
			session.persist(student3);
			
			//setting student to schools
			school1.addStudent(student1);
			school1.addStudent(student2);
			school2.addStudent(student3);
			
			tx.commit();
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		System.out.println("\n------------------------Retrieving Data------------------------------");
		// Retrieve all schools with the corresponding owners and Output to the console 
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve all Schools
			List<School> schoolsList = session.createQuery("from School", School.class).list();
			for (School p : schoolsList) {
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
