package com.miu.edu.cs544.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miu.edu.cs544.model.CountryRegion;

@Repository
@Transactional(readOnly = true)
public interface CountryRegionRepository extends JpaRepository<CountryRegion, String>{

}
