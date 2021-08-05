package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.client1.model.CountryRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CountryRegionRepository extends JpaRepository<CountryRegion, String> {

}
