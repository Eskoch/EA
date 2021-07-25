package edu.miu.cs.cs544.examples.c;


import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Getter @Setter 
@ToString
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@OneToMany(cascade={CascadeType.PERSIST})
	@JoinColumn(name="school_id")
	@MapKey(name="studentId")
	private Map<String, Student> students = new HashMap<>();

	public School(String name) {
		this.name = name;
	}
	
	public void addStudent(Student student) {
		students.put(student.getStudentId(), student);
	}

}
