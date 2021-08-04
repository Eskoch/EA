package com.miu.edu.cs544.controller;

import com.miu.edu.cs544.model.CountryRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.miu.edu.cs544.service.CountryRegionServiceImp;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryRegionController {
    @Autowired
    private CountryRegionServiceImp countryRegionService;

    @GetMapping
    public List<CountryRegion> countryRegionList() {
        return countryRegionService.findAll();
    }

    @GetMapping("/{id}")
    public CountryRegion getCountryRegion(@PathVariable(name="id") String countryRegionCode) {
        return countryRegionService.find(countryRegionCode);
    }

}
