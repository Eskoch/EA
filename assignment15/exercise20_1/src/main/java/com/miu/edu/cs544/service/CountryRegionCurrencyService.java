package com.miu.edu.cs544.service;


import com.miu.edu.cs544.model.CountryRegionCurrency;

import java.util.List;

public interface CountryRegionCurrencyService {
    List<CountryRegionCurrency> findAll();
    CountryRegionCurrency find(String countryRegionCode);
}

