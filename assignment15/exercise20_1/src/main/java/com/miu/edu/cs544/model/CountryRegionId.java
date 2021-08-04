package com.miu.edu.cs544.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class CountryRegionId implements Serializable {
    @Column(length = 3, nullable = false)
    private String countryRegionCode;

    @Column(length = 3, nullable = false)
    private String currencyCode;
}
