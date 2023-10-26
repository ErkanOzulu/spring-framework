package com.mycomp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String name;
    private String surName;
    private String email;
    private String address;

    /**
     * Fetch.EAGER --whenever system runs if you need payment it will bring all merchant info -- default eager
     * Fetch.LAZY merchant info come when it is needed but if you ask only payment info merchant info will not come from system--performance situation
     **/
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Payment> payments;

    public Customer(String userName, String name, String surName, String email, String address) {
        this.userName = userName;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.address = address;
    }
}

