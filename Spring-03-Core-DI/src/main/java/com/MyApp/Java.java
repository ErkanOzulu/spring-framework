package com.MyApp;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

@AllArgsConstructor
@Component
public class Java {
    // Field Injection

    // @Autowired
    // OfficeHours officeHours;


    // Constructor Injection
    OfficeHours officeHours;
    //@Autowired  --> After spring version 4.3 if there is only one constructor it will do automatically
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    public void getTeachingHours(){
        System.out.println("Weekly teaching hours : " + (20 + officeHours.getHours()));
    }

}
