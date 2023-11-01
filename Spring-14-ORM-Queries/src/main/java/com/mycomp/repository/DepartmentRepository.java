package com.mycomp.repository;

import com.mycomp.entity.Department;
import com.mycomp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    /**
     * Derived query
     */
    //Display all departments in the furniture department

    List<Department> findByDepartment(String department);

    //Display all departments in the Health Division

    List<Department> findByDivisionEquals(String division);

    List<Department> findByDivisionIs(String division);


    //Display top 3 departments with division name includes 'Hea', without duplicates

    List<Department> findDistinctTop3ByDivisionIsContaining(String pattern);

    List<Department> findDistinctTop3ByDivisionContains(String pattern);

    /**
     * JPQL Query
     * positional parameters
     */

    @Query("select d from Department d where d.division in ?1")
    List<Department> getDepartmentDivision(List<String> division);


    /**Named Queries - this way isn't  preferred very much

     To make developer’s life easier, Spring Data JPA provides the concept of named
     queries that can be defined by using a properties file, annotations, or an XML
     file. You can group related queries in one place and refer them in your code by
     their names. Spring Data JPA will take care of all the boilerplate code required to
     execute these queries.
     * create a Directory under resources and named "META-INF" and below create a file "jpa-named-queries.properties" and declare quires in here
     *

     */
    List<Department>retrieveDepartmentByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContains(String  pattern);
}
