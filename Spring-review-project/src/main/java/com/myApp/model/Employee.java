package com.myApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private String name;
    private String department;
    private int hourlyRate;
}
