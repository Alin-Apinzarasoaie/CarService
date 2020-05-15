package com.carservice.Utils;

import com.carservice.entities.employee.Employee;
import com.carservice.entities.employee.EmployeeStatus;

import java.util.UUID;

public interface IEmployeeUtils {

    void printAllEmployees();

    Employee getEmployeeByUUID(UUID uuid);

    void addEmployee(Employee employee);

    void deleteEmployee(UUID uuid);

    void updateEmployee(UUID uuid, String phoneNumber, EmployeeStatus employeeStatus);

    double calculateSalary(UUID uuid);

    Boolean checkEmployee(Employee employee);

}
