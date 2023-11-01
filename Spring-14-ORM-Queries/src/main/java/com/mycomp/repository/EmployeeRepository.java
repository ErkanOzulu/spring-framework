package com.mycomp.repository;

import com.mycomp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /**
     * DERIVED QUERY
     */
    //Display all employees with email address ' '
    List<Employee> findByEmail(String email);

    //Display all employees with firstname ' '  and lastname '', also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname, String lastname, String email);


    //Display all employees that firstname is not ''
    List<Employee> findByFirstNameNot(String firstName);

    //Display all employees where last name starts with ''
    List<Employee> findByLastNameStartsWith(String pattern);


    //Display all employees with salaries higher than ''
    List<Employee> findBySalaryGreaterThan(Integer salary);


    //Display all employees with salaries less than equal ''
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    //Display all employees that has been hired between '' and  ''
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater and equal to '' in order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();

    /**
     * JPQL QUERY
     * use class name "Employee" not table name
     * positional parameters - ?1,?2 ..
     * named parameters - :name, :lastname ..
     */
    @Query("select e from Employee e where e.email='btrow5@technorati.com'")
    Employee getEmployeeDetail();

    @Query("select e.salary from Employee e where e.email='btrow5@technorati.com'")
    Integer getEmployeeSalary();


    @Query("select e from Employee e where e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("select e from Employee e where e.email=?1 and e.salary=?2")
    Employee getEmployeeDetail(String email, int Salary);


    //Not equal
    @Query("SELECT e FROM Employee e WHERE e.salary<>?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    //like/contains/startswith/endswith
    @Query("SELECT e FROM Employee e WHERE e.firstName like ?1")
    List<Employee> getEmployeeFirstNameLike(String name);

    //less than
    @Query("select e from Employee e where e.salary<?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    //greater than
    @Query("select e from Employee e WHERE e.salary>?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    //Before
    @Query("select e from Employee e where e.hireDate<?1")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);

    //Between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeSalaryBetween(int salary1, int salary2);

    //Null
    @Query("select e from Employee e where e.email is null ")
    List<Employee> getEmployeeEmailIsNull();

    //Not Null
    @Query("select e from Employee e where  e.email is not null ")
    List<Employee> getEmployeeEmailIsNotNull();

    //Sorting in ascending order
    @Query("select e from Employee e ORDER BY e.salary")
    List<Employee> getEmployeeSalaryOrderAsc();

    //Sorting in descending order
    @Query("select e from Employee e order by e.salary desc")
    List<Employee> getEmployeeSalaryOrderDesc();


    // named parameters - :name, :lastname ..

    @Query("select e from Employee e where e.salary=:salary")
    List<Employee> getEmployeeSalary(@Param("salary") int salary);


    /**
     * native SQL query
     * add nativeQuery=true to declare which query type
     * we use table name "employees" not class name "Employee"
     */
    @Query(value = "select * from employees where salary =?1", nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salary);


    /**
     * @Modifying
     * use with @Transactional
     * It is used to enhance the @Query annotation to execute not only SELECT queries but also INSERT, UPDATE, DELETE queries.
     */


    @Modifying
    @Transactional
    @Query("update Employee e set e.email='admin@email.com' where e.id=:id")
    void updateEmployeeJPQL(@Param("id") int id);


    @Modifying
    @Transactional
    @Query( value = "update employees  set e.email='admin@email.com' where id=:id",nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") int id);





}




