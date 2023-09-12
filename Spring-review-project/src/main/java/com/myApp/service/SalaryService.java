package com.myApp.service;

import com.myApp.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.myApp.repository.EmployeeRepository;

@Component
public class SalaryService {

        EmployeeRepository employeeRepository;
        HoursRepository hoursRepository;


//@Autowired
    public SalaryService(EmployeeRepository employeeRepository, @Qualifier("RH") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateRegularSalary(){
            //HourlyRate * Regular Hours

            System.out.println(employeeRepository.getHourlyRate() * hoursRepository.getHours());
        }


    }

