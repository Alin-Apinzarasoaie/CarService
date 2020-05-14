package com.carservice.entities.employee;

import java.time.LocalDate;
import java.util.UUID;

public abstract class BaseEmployee {

    private UUID id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private LocalDate employmentDate;

    private double salaryCoefficient;

    public BaseEmployee(String firstName, String lastName, LocalDate birthDate, LocalDate employmentDate) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(double salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    @Override
    public String toString() {
        return "BaseEmployee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", employmentDate=" + employmentDate +
                ", salaryCoefficient=" + salaryCoefficient +
                '}';
    }
}
