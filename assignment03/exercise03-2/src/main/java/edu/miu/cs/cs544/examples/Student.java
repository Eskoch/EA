package edu.miu.cs.cs544.examples;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

public class Student {
	@Id
	@GeneratedValue
	private long id;
	private int studentId;
	private String firstName;
	private String lastName;
	
	@ManyToOne
	@JoinTable(name = "Student_Course", 
				joinColumns = { @JoinColumn(name="Student_Id")}, 
				inverseJoinColumns = { @JoinColumn(name="Course_Id")}
			  )
	private List<Course> courses = new ArrayList<>();
	
	public Student() {}

	public Student(int studentId, String firstName, String lastName) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	

}
