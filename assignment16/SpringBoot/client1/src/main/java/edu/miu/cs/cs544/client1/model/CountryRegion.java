package edu.miu.cs.cs544.client1.model;

import lombok.Data;

import java.util.List;

@Data
public class CountryRegion {
    private String id;

    private String name;

    private List<StateProvince> states;

}
