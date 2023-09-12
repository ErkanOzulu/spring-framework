package repository;

import model.Employee;

public class DBEmployeeRepository implements EmployeeRepository{
//Assume we are getting this data from db
    @Override
    public int getHourlyRate() {
        Employee employee=new Employee("Harold finch","IT",65);

        return employee.getHourlyRate();

    }
}
