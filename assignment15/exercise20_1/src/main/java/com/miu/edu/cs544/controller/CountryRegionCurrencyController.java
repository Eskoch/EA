package com.miu.edu.cs544.controller;

import com.miu.edu.cs544.model.CountryRegionCurrency;
import com.miu.edu.cs544.service.CountryRegionCurrencyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CountryRegionCurrencyController {
    @Autowired
    private CountryRegionCurrencyServiceImp countryRegionCurrencyService;

    @GetMapping
    public List<CountryRegionCurrency> countryRegionCurrencyList() {
        return countryRegionCurrencyService.findAll();
    }

    @GetMapping("/{id}")
    CountryRegionCurrency getCountryRegionCurrency(@PathVariable(name="id") String countryRegionCurrencyCode) {
        return countryRegionCurrencyService.find(countryRegionCurrencyCode);
    }
}
