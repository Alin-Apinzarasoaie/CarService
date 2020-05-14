package com.carservice;

import com.carservice.entities.employee.Employee;
import com.carservice.entities.employee.EmployeeUtilsImpl;
import com.carservice.entities.employee.EmployeeStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        EmployeeUtilsImpl employeeUtils = EmployeeUtilsImpl.getInstance();

        Scanner keyboard = new Scanner(System.in);

        boolean secondSwitch = true;



        while (true) {
            System.out.println("---Optiuni principale---");
            System.out.println("0. Inchideti programul");
            System.out.println("1. Operatii Angajati");
            System.out.println("2. Operatii Masini");
            System.out.println("Introduceti optiunea dumneavoastra: ");

            String option = keyboard.next();

            switch (option) {
                case "0":
                    System.exit(0);
                    break;

                case "1":
                    while (secondSwitch) {
                        System.out.println("---Optiuni Principale---");
                        System.out.println("0. Inapoi");
                        System.out.println("1. Adaugare angajat");
                        System.out.println("2. Stergere angajat");
                        System.out.println("3. Editare angajat");
                        System.out.println("4. Afisare angajat");
                        System.out.println("5. Afisarea salariului unui angajat");
                        System.out.println("6. Afisarea tuturor angajatilor");

                        String employeeOption = keyboard.next();

                        switch (employeeOption) {
                            case "0":
                                secondSwitch = false;
                                break;

                            case "1":
                                boolean thirdSwitch = true;

                                while (thirdSwitch) {
                                    System.out.println("Ati selectat optiunea Adaugare Angajat.");
                                    System.out.println("Va rog precizati statusul angajatului: ");
                                    System.out.println("0. Inapoi");
                                    System.out.println("1. Asistent");
                                    System.out.println("2. Mecanic");
                                    System.out.println("3. Director");

                                    String employeeStatus = keyboard.next();

                                    switch (employeeStatus) {
                                        case "0":
                                            thirdSwitch = false;
                                            break;
                                        case "1":
                                            System.out.println("Ati selectat optiunea Adaugare asistent");
                                            System.out.println("Introduceti numele:");
                                            String assistentFirstName = keyboard.next();
                                            System.out.println("Introduceti prenumele: ");
                                            String assistentLastName = keyboard.next();
                                            System.out.println("Introduceti data nasterii sub forma (yyyy-MM-dd) Exemplu: 1997-11-30");
                                            String assistentBirthday = keyboard.next();
                                            if(!employeeUtils.checkDate(assistentBirthday)){
                                                break;
                                            }
                                            LocalDate assistantBirthdayDate = LocalDate.parse(assistentBirthday, DateTimeFormatter.ISO_LOCAL_DATE);
                                            System.out.println("Introduceti data angajarii sub forma (yyyy-MM-dd) Exemplu: 2016-04-12");
                                            String assistentEmployment = keyboard.next();
                                            if(!employeeUtils.checkDate(assistentEmployment)){
                                                break;
                                            }
                                            LocalDate assisentemploymentDate = LocalDate.parse(assistentEmployment, DateTimeFormatter.ISO_LOCAL_DATE);
                                            System.out.println("Introduceti numarul de telefon: ");
                                            String assistentPhoneNumber = keyboard.next();

                                            Employee assistent = new Employee(assistentFirstName, assistentLastName, assistantBirthdayDate, assisentemploymentDate, assistentPhoneNumber, EmployeeStatus.ASSISTENT);

                                            if (employeeUtils.checkEmployee(assistent)) {
                                                employeeUtils.addEmployee(assistent);
                                                System.out.println("Angajat adaugat :)");
                                            }
                                            break;
                                        case "2":
                                            System.out.println("Ati selectat optiunea Adaugare mecanic");
                                            System.out.println("Introduceti numele:");
                                            String mechanicFirstName = keyboard.next();
                                            System.out.println("Introduceti prenumele: ");
                                            String mechanicLastName = keyboard.next();
                                            System.out.println("Introduceti data nasterii sub forma (yyyy-MM-dd) Exemplu: 1997-11-30");
                                            String mechanicBirthday = keyboard.next();
                                            if(!employeeUtils.checkDate(mechanicBirthday)){
                                                break;
                                            }
                                            LocalDate mechanicBirthdayDate = LocalDate.parse(mechanicBirthday);
                                            System.out.println("Introduceti data angajarii sub forma (yyy.MM-dd) Exemplu: 2016-04-12");
                                            String mechanicEmployment = keyboard.next();
                                            if(!employeeUtils.checkDate(mechanicEmployment)){
                                                break;
                                            }
                                            LocalDate mechanicEmploymentDate = LocalDate.parse(mechanicEmployment);
                                            System.out.println("Introduceti numarul de telefon: ");
                                            String mechanicPhoneNumber = keyboard.next();

                                            Employee mechanic = new Employee(mechanicFirstName, mechanicLastName, mechanicBirthdayDate, mechanicEmploymentDate, mechanicPhoneNumber, EmployeeStatus.MECHANIC);

                                            if (employeeUtils.checkEmployee(mechanic)) {
                                                employeeUtils.addEmployee(mechanic);
                                                System.out.println("Angajat adaugat :)");
                                            }
                                            break;
                                        case "3":
                                            System.out.println("Ati selectat optiunea Adaugare director");
                                            System.out.println("Introduceti numele:");
                                            String directorFirstName = keyboard.next();
                                            System.out.println("Introduceti prenumele: ");
                                            String directorLastName = keyboard.next();
                                            System.out.println("Introduceti data nasterii sub forma (yyyy-MM-dd) Exemplu: 1997-11-30");
                                            String directorBirthday = keyboard.next();
                                            if(!employeeUtils.checkDate(directorBirthday)){
                                                break;
                                            }
                                            LocalDate directorBirthdayDate = LocalDate.parse(directorBirthday);
                                            System.out.println("Introduceti data angajarii sub forma (yyy.MM-dd) Exemplu: 2016-04-12");
                                            String directorEmployment = keyboard.next();
                                            if(!employeeUtils.checkDate(directorEmployment)){
                                                break;
                                            }
                                            LocalDate directorEmploymentDate = LocalDate.parse(directorEmployment);
                                            System.out.println("Introduceti numarul de telefon: ");
                                            String directorPhoneNumber = keyboard.next();

                                            Employee director = new Employee(directorFirstName, directorLastName, directorBirthdayDate, directorEmploymentDate, directorPhoneNumber, EmployeeStatus.DIRECTOR);

                                            if (employeeUtils.checkEmployee(director)) {
                                                employeeUtils.addEmployee(director);
                                                System.out.println("Angajat adaugat :)");
                                            }
                                            break;
                                        default:
                                            System.out.println("Optiune gresita.");
                                    }
                                }
                                break;
                            case "2":
                                System.out.println("Ati selectat optiunea Stergere angajat.");
                                System.out.println("Va rog introduceti ID-ul angajatului pe care doriti sa-l stergeti: ");
                                String deleteEmployeeId = keyboard.next();

                                if(!employeeUtils.isStringUUID(deleteEmployeeId))
                                    break;

                                Optional<Employee> deleteOptionalEmployee = Optional.ofNullable(employeeUtils.getEmployeeByUUID(UUID.fromString(deleteEmployeeId)));

                                deleteOptionalEmployee.ifPresent(employee ->  {
                                    employeeUtils.deleteEmployee(UUID.fromString(deleteEmployeeId));
                                    System.out.println("Angajatul cu id: " + deleteEmployeeId + " a fost sters cu succes.");
                                });
                                break;
                            case "3":
                                System.out.println("Ati selectat optiunea Editare angajat");
                                System.out.println("Va rog introduceti ID-ul angajatului pe care doriti sa-l editati: ");
                                String updateEmplyeeId = keyboard.next();

                                if(!employeeUtils.isStringUUID(updateEmplyeeId))
                                    break;

                                Optional<Employee> updateOptionalEmployee = Optional.ofNullable(employeeUtils.getEmployeeByUUID(UUID.fromString(updateEmplyeeId)));

                                if(updateOptionalEmployee.isEmpty()){
                                    break;
                                }

                                System.out.println("Introduceti noul numar de telefon");
                                String employeeNewNumberPhone = keyboard.next();

                                System.out.println("Doriti sa-i editati si statusul?");
                                System.out.println("1. Da");
                                System.out.println("2. Nu");

                                String statusOption = keyboard.next();

                                switch (statusOption) {
                                    case "1":
                                        System.out.println("Alegeti noul status al angajatului: ");
                                        System.out.println("1. Asistent");
                                        System.out.println("2. Mecanic");
                                        System.out.println("3. Director");

                                        String newStatusOption = keyboard.next();

                                        switch (newStatusOption) {
                                            case "1":
                                                employeeUtils.updateEmployee(UUID.fromString(updateEmplyeeId), employeeNewNumberPhone, EmployeeStatus.ASSISTENT);
                                                System.out.println("Angajat editat cu succes.");
                                                break;
                                            case "2":
                                                employeeUtils.updateEmployee(UUID.fromString(updateEmplyeeId), employeeNewNumberPhone, EmployeeStatus.MECHANIC);
                                                System.out.println("Angajat editat cu succes.");
                                                break;
                                            case "3":
                                                employeeUtils.updateEmployee(UUID.fromString(updateEmplyeeId), employeeNewNumberPhone, EmployeeStatus.DIRECTOR);
                                                System.out.println("Angajat editat cu succes.");
                                                break;
                                            default:
                                                System.out.println("Optiunea gresita!");
                                        }
                                        break;
                                    case "2":
                                        employeeUtils.updateEmployee(UUID.fromString(updateEmplyeeId), employeeNewNumberPhone, employeeUtils.getEmployeeByUUID(UUID.fromString(updateEmplyeeId)).getStatus());
                                        System.out.println("Angajatul cu id: " + updateEmplyeeId + "a fost editat cu succes.");
                                        break;
                                    default:
                                        System.out.println("Optiunea gresita!");
                                }
                                break;
                            case "4":
                                System.out.println("Ati selectat optiunea Afisare angajat.");
                                System.out.println("Va rog introduceti ID-ul angajatului pe care doriti sa-l afisati: ");
                                String printEmployeeId = keyboard.next();

                                if(!employeeUtils.isStringUUID(printEmployeeId))
                                    break;

                                Optional<Employee> optionalEmployee = Optional.ofNullable(employeeUtils.getEmployeeByUUID(UUID.fromString(printEmployeeId)));

                                optionalEmployee.ifPresent(employee -> System.out.println(employee.toString()));
                                break;

                            case "5":
                                System.out.println("Ati selectat optiunea Afisarea salariului unui angajat");
                                System.out.println("Va rog introduceti ID-ul anagalatului caruia doriti sa-i vedeti salariul: ");
                                String salaryEmployeeId = keyboard.next();

                                if(!employeeUtils.isStringUUID(salaryEmployeeId))
                                    break;

                                Optional<Employee> salaryOptionalEmployee = Optional.ofNullable(employeeUtils.getEmployeeByUUID(UUID.fromString(salaryEmployeeId)));

                                salaryOptionalEmployee.ifPresent(employee -> System.out.println("Angajatul cu id-ul: " + salaryEmployeeId + " are salariul de: " + employeeUtils.calculateSalary(salaryOptionalEmployee.get().getId()) + "RON"));

                                break;
                            case "6":
                                System.out.println("Ati selectat optiunea Afisarea tuturor angajatilor.");
                                if(employeeUtils.getAllEmployees().isEmpty()) {
                                    System.out.println("Deocamdata nu exista nici un angajat.");
                                    break;
                                }
                                    employeeUtils.printAllEmployees();
                                break;
                            default:
                                System.out.println("Optiune gresita.");
                        }
                    }
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Optiune gresita.");
            }
        }
    }
}

