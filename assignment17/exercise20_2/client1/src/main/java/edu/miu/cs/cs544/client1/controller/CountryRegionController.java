package edu.miu.cs.cs544.client1.controller;

import edu.miu.cs.cs544.client1.model.CountryRegion;
import edu.miu.cs.cs544.client1.service.CountryRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryRegionController {
    @Autowired
    private CountryRegionService countryRegionService;

    @GetMapping
    public List<CountryRegion> countryRegionList() {
        return countryRegionService.findAll();
    }

    @GetMapping("/{code}")
    public CountryRegion findCountryRegion(@PathVariable(name="code") String countryRegionCode) {
        return countryRegionService.findById(countryRegionCode);
    }
}
