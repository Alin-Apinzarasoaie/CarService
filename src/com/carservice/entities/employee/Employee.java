package com.carservice.entities.employee;

import java.time.LocalDate;

public class Employee extends BaseEmployee{

    private String phoneNumber;

    private EmployeeStatus status;

    public Employee(String firstName, String lastName, LocalDate birthDate, LocalDate employmentDate, String phoneNumber, EmployeeStatus status) {
        super(firstName, lastName, birthDate, employmentDate);
        this.phoneNumber = phoneNumber;
        this.status = status;
        updateSalaryCoeficient(status);
    }

    private void updateSalaryCoeficient(EmployeeStatus status) {
        if(status == EmployeeStatus.DIRECTOR) {
            setSalaryCoefficient(EmployeeCoefficient.DIRECTOR_COEFFICIENT);
        } else if(status == EmployeeStatus.MECHANIC) {
            setSalaryCoefficient(EmployeeCoefficient.MECHANIC_COEFFICIENT);
        } else if(status == EmployeeStatus.ASSISTENT) {
            setSalaryCoefficient(EmployeeCoefficient.ASSISTENT_COEFFICIENT);
        }
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
        updateSalaryCoeficient(status);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", status=" + status +
                '}' + super.toString();
    }
}
