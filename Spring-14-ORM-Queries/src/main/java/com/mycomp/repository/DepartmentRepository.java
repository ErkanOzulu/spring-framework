package com.mycomp.repository;

import com.mycomp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    //Display all departments in the furniture department

    List<Department>findByDepartment(String department);

    //Display all departments in the Health Division

    List<Department>findByDivisionEquals(String division);
    List<Department>findByDivisionIs(String division);


    //Display top 3 departments with division name includes 'Hea', without duplicates

List<Department> findDistinctTop3ByDivisionIsContaining(String pattern);
List<Department> findDistinctTop3ByDivisionContains(String pattern);


}
