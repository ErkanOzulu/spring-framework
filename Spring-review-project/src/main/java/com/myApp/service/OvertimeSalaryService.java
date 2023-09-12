package com.myApp.service;

import com.myApp.repository.EmployeeRepository;
import com.myApp.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OvertimeSalaryService {
    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;

    public OvertimeSalaryService(EmployeeRepository employeeRepository, @Qualifier("OH") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }
    public void calculateOvertimeSalary(){
        System.out.println(employeeRepository.getHourlyRate() * hoursRepository.getHours());

    }

}
