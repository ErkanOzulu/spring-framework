package com.myApp.service;

import com.myApp.repository.HoursRepository;
import org.springframework.stereotype.Component;
import com.myApp.repository.EmployeeRepository;

@Component
public class SalaryService {

        EmployeeRepository employeeRepository;
        HoursRepository hoursRepository;



    public SalaryService(EmployeeRepository employeeRepository, HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateRegularSalary(){
            //HourlyRate * Regular Hours

            System.out.println(employeeRepository.getHourlyRate() * hoursRepository.getHours());
        }


    }

