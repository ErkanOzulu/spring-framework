package com.mycomp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity(name="carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name = "car_item_ref",joinColumns = @JoinColumn(name = "c_id"),inverseJoinColumns = @JoinColumn(name = "i_id"))
    private List<Item>itemList;


   }
