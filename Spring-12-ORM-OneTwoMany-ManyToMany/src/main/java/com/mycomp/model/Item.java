package com.mycomp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity(name="items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    @ManyToMany(mappedBy = "itemList")
    private List<Cart>carts;

    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }
}



