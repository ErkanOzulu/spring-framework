package com.mycomp.entity;

import com.mycomp.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "students")
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generate auto id
    @Id
    private Long id;
    @Column(name = "studentFirstName")
    private String firstName;
    @Column(name = "studentLastName",length = 100)
    private String lastName;
    private String email;
    @Transient //This column doesn't show in table
    private String city;
    @Column(columnDefinition = "Date")
    private LocalDate birthDate;
    @Column(columnDefinition = "Time")
    private LocalTime birthTime;
    @Column(columnDefinition = "Timestamp")
    private LocalDate birthDateTime;
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
