package com.miu.edu.cs544.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Person.CountryRegion")
@NoArgsConstructor @Getter @Setter 
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CountryRegion {
	
	@Id
	@Column(length = 3)
	private String countryRegionCode;

	@Column(length = 50, nullable = false)
	private String name;
	
	private LocalDate modifiedDate;
	
}