package com.mycomp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@Entity(name = "departments")
public class Department extends BaseEntity {

    private String department;
    private String division;
    @OneToOne(mappedBy = "department") //Bidirectional relationship
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
