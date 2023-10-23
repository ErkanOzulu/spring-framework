package com.mycomp.repository;

import com.mycomp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //it is not mandatory.
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
