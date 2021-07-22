package edu.miu.cs.cs544.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@ToString
@Table(name="myOwner")
public class Owner {
	@Id
	@GeneratedValue
	private long id;
	private String firstname;
	private String lastname;
	
	@OneToMany(cascade={CascadeType.PERSIST})
	@JoinColumn(name="ownerId")
	private List<Car> cars = new ArrayList<Car>();

	public Owner() {
	}

	public Owner(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return firstname + " " + lastname;
	}

	public void setName(String name) {
		StringTokenizer st = new StringTokenizer(name);
		firstname = st.nextToken();
		lastname = st.nextToken();
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void addCar(Car car) {
		cars.add(car);
		System.out.println("Car successfully added to " + this.firstname);
	}
	
	public List<Car> getCars() {
		return cars;
	}
	
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
