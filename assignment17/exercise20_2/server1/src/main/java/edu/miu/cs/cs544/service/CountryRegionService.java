package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.CountryRegion;

import java.util.List;


public interface CountryRegionService {
	CountryRegion findById(String id);
	List<CountryRegion> findAll();

}
