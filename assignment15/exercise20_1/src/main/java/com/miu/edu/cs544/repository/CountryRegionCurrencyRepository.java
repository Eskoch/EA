package com.miu.edu.cs544.repository;

import com.miu.edu.cs544.model.CountryRegionCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface CountryRegionCurrencyRepository extends JpaRepository<CountryRegionCurrency, String> {
}
