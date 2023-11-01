package com.mycomp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@Data
public class Course {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name="RATING")
    private int rating;
    @Column(name = "DESCRIPTION")
    private String description;



}
