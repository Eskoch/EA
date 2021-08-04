package com.miu.edu.cs544.service;

import com.miu.edu.cs544.model.CountryRegion;
import com.miu.edu.cs544.model.CountryRegionCurrency;
import com.miu.edu.cs544.repository.CountryRegionCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountryRegionCurrencyServiceImp implements CountryRegionCurrencyService{
    @Autowired
    private CountryRegionCurrencyRepository countryRegionCurrencyRepository;

    public List<CountryRegionCurrency> findAll() {
        return countryRegionCurrencyRepository.findAll();
    }

    public CountryRegionCurrency find(String countryRegionCode) {
        return countryRegionCurrencyRepository.getById(countryRegionCode);
    }
}
