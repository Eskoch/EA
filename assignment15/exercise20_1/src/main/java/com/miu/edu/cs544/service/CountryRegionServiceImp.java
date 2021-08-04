package com.miu.edu.cs544.service;

import com.miu.edu.cs544.model.CountryRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.miu.edu.cs544.repository.CountryRegionRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CountryRegionServiceImp implements CountryRegionService{
    @Autowired
    private CountryRegionRepository countryRegionRepository;

    public List<CountryRegion> findAll() {
        return countryRegionRepository.findAll();
    }

    public CountryRegion find(String countryRegionCode) {
        return countryRegionRepository.getById(countryRegionCode);
    }
}
