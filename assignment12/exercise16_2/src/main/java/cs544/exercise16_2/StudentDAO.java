package cs544.exercise16_2;

import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudentDAO {
	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

//	private Collection<Student> studentlist =


	public StudentDAO() {
		Student student = new Student(11334, "Frank", "Brown");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.addCourse(course1);
		student.addCourse(course2);
		sessionFactory.getCurrentSession().persist(student);

	}

	public Student load(long studentid) {
		Student student =sessionFactory.getCurrentSession().get(Student.class,studentid);//loadAccount(account.getAccountnumber());

		return student;
	}
}
