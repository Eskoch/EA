package com.miu.edu.cs544.service;

import com.miu.edu.cs544.model.CountryRegion;

import java.util.List;

public interface CountryRegionService {
    List<CountryRegion> findAll();
    CountryRegion find(String countryRegionCode);
}
