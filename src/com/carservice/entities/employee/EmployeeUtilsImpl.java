package com.carservice.entities.employee;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public final class EmployeeUtilsImpl implements IEmployeeUtils {

    private static EmployeeUtilsImpl INSTANCE;

    private static final int SALARY_ADDITION = 1000;

    private static final int MONTHS_OF_A_YEAR = 12;

    private ArrayList<Employee> allEmployees = new ArrayList<>();

    public static EmployeeUtilsImpl getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new EmployeeUtilsImpl();
        }
        return INSTANCE;
    }

    private EmployeeUtilsImpl() {

    }

    public ArrayList<Employee> getAllEmployees() {
        return allEmployees;
    }

    public void setAllEmployees(ArrayList<Employee> allEmployees) {
        this.allEmployees = allEmployees;
    }

    @Override
    public void printAllEmployees() {
        allEmployees.forEach(System.out::println);
    }

    @Override
    public Employee getEmployeeByUUID(UUID uuid) {
        for(Employee e : allEmployees) {
            if(e.getId().equals(uuid)) {
                return e;
            }
        }
        System.out.println("Nu am putut gasi angajatul cu id-ul: " + uuid);
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {
        allEmployees.add(employee);
    }

    @Override
    public void deleteEmployee(UUID uuid) {
        Optional<Employee> optionalEmployee = Optional.ofNullable(getEmployeeByUUID(uuid));

        allEmployees.remove(optionalEmployee.orElse(null));
    }

    @Override
    public void updateEmployee(UUID uuid, String phoneNumber, EmployeeStatus employeeStatus) {
        Optional<Employee> optionalEmployee = Optional.ofNullable(getEmployeeByUUID(uuid));
        assert optionalEmployee.orElse(null) != null;
        optionalEmployee.orElse(null).setPhoneNumber(phoneNumber);
        optionalEmployee.orElse(null).setStatus(employeeStatus);
    }

    @Override
    public double calculateSalary(UUID uuid) {
        Optional<Employee> optionalEmployee = Optional.ofNullable(getEmployeeByUUID(uuid));
        LocalDate now = LocalDate.now();

        Period difference = Period.between(optionalEmployee.orElse(null).getEmploymentDate(), now);

        int seniority = ((difference.getYears() * MONTHS_OF_A_YEAR) + difference.getMonths());

        return (seniority * optionalEmployee.get().getSalaryCoefficient() * SALARY_ADDITION);
    }

    @Override
    public Boolean checkEmployee(Employee employee) {

        long employeeAge = LocalDate.from(employee.getBirthDate()).until(LocalDate.now(), ChronoUnit.YEARS);
        LocalDate employmentDate = employee.getEmploymentDate();

        if(employee.getFirstName().isEmpty()) {
            System.out.println("Prenumele angajatului este gol!");
            return false;
        } else if (employee.getLastName().isEmpty()) {
            System.out.println("Numele angajatului este gol!");
            return false;
        } else if(employee.getFirstName().length() > 30) {
            System.out.println("Prenumele angajatului depaseste 30 de caractere!");
            return false;
        } else if(employee.getLastName().length() > 30) {
            System.out.println("Numele angajatului depaseste 30 de caractere!");
            return false;
        } else if(employeeAge < 18) {
            System.out.println("Angajatul trebuie sa aiba mai mult de 18 ani!");
            return false;
        } else if(employmentDate.isAfter(LocalDate.now())) {
            System.out.println("Data angajarii trebuie sa fie inainte de: "+ LocalDate.now());
            return false;
        }
        return true;
    }
}
