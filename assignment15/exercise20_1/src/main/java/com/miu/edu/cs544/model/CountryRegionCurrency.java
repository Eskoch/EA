package com.miu.edu.cs544.model;


import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "[AdventureWorks2019].[Sales].[CountryRegionCurrency]")
public class CountryRegionCurrency implements Serializable {
    @EmbeddedId
    private CountryRegionId identifier;
    private LocalDate ModifiedDate;
}
