package edu.miu.cs.cs544.examples;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Course {
	@Id
	@GeneratedValue
	private long id;
	
	private int courseId;
	private String courseNumber;
	private String name;
	
	@ManyToMany(mappedBy="courses")
	private List<Student> students = new ArrayList<>();
	
	public Course() {}

	public Course(int courseId, String courseNumber, String name, List<Student> students) {
		super();
		this.courseId = courseId;
		this.courseNumber = courseNumber;
		this.name = name;
		this.students = students;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}

}
