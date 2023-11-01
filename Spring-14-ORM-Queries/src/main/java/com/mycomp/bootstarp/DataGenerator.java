package com.mycomp.bootstarp;

import com.mycomp.entity.Region;
import com.mycomp.repository.CoursesRepository;
import com.mycomp.repository.DepartmentRepository;
import com.mycomp.repository.EmployeeRepository;
import com.mycomp.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
@Transactional //added for execute Line91 direct stream methods
@Component
public class DataGenerator implements CommandLineRunner {


    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CoursesRepository coursesRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CoursesRepository coursesRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.coursesRepository = coursesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("------------------REGION START------------------");


        List<Region> canada = regionRepository.findByCountry("Canada");
        System.out.println("findByCountry: " + canada);

        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));

        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));

        System.out.println("findByCountryIsContainingOrderByCountry: " + regionRepository.findByCountryIsContainingOrderByCountry("Asia"));

        System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("------------------REGION END------------------");

        System.out.println("------------------DEPARTMENT START------------------");

        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Toys"));


        System.out.println("findByDivisionIs: " + departmentRepository.findByDivisionIs("Outdoors")
        );

        System.out.println("findDistinctTop3ByDivisionIsContaining" + departmentRepository.findDistinctTop3ByDivisionIsContaining("Hea"));
        System.out.println("findDistinctTop3ByDivisionContains" + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));

        System.out.println("------------------DEPARTMENT END------------------");


        System.out.println("------------------EMPLOYEE START------------------");

        System.out.println("findByLastNameStartsWith: " + employeeRepository.findByLastNameStartsWith("Rowan"));
        System.out.println("getEmployeeDetail: " + employeeRepository.getEmployeeDetail());

        System.out.println("getEmployeeSalary: " + employeeRepository.getEmployeeSalary());


        System.out.println("------------------EMPLOYEE END------------------");
        System.out.println("------------------COURSE START------------------");


        coursesRepository.findByCategory("Spring").forEach(System.out::println);

        System.out.println("-------------------------------------");

        coursesRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);
        System.out.println("-------------------------------------");

        System.out.println(coursesRepository.existsByName("Javascript for All"));
        System.out.println("-------------------------------------");
        System.out.println(coursesRepository.countByCategory("Spring"));

        System.out.println("-------------------------------------");
        coursesRepository.findByNameStartsWith("Scalable").forEach(System.out::println);

        System.out.println("-------------------------------------");

        coursesRepository.streamByCategory("Spring").forEach(System.out::println);

        System.out.println("------------------COURSE END------------------");
    }
}
