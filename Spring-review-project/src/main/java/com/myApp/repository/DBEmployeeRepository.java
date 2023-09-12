package com.myApp.repository;

import com.myApp.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{
//Assume we are getting this data from db
    @Override
    public int getHourlyRate() {
        Employee employee=new Employee("Harold finch","IT",65);

        return employee.getHourlyRate();

    }
}
