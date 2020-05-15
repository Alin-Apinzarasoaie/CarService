package com.carservice.entities.workshop;

import com.carservice.Utils.EmployeeUtilsImpl;
import com.carservice.entities.Job.Job;
import com.carservice.entities.car.BusVehicle;
import com.carservice.entities.car.StandardVehicle;
import com.carservice.entities.car.TruckVehicle;
import com.carservice.entities.car.Vehicle;
import com.carservice.entities.employee.Employee;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Workshop implements IWorkshop {

    private EmployeeUtilsImpl employeeUtils = EmployeeUtilsImpl.getInstance();

    private ConcurrentLinkedQueue<Job> waitingVehicles = new ConcurrentLinkedQueue<>();

    private ConcurrentLinkedQueue<Employee> freeEmployee = new ConcurrentLinkedQueue<>();

    private ConcurrentHashMap<Employee, Job> employeeWorkingAtAVehicle = new ConcurrentHashMap<>();


    public ConcurrentLinkedQueue<Job> getWaitingVehicles() {
        return waitingVehicles;
    }

    public void setWaitingVehicles(ConcurrentLinkedQueue<Job> waitingVehicles) {
        this.waitingVehicles = waitingVehicles;
    }

    public ConcurrentHashMap<Employee, Job> getEmployeeWorkingAtAVehicle() {
        return employeeWorkingAtAVehicle;
    }

    public void setEmployeeWorkingAtAVehicle(ConcurrentHashMap<Employee, Job> employeeWorkingAtAVehicle) {
        this.employeeWorkingAtAVehicle = employeeWorkingAtAVehicle;
    }

    public ConcurrentLinkedQueue<Employee> getFreeEmployee() {
        return freeEmployee;
    }

    public void setFreeEmployee(ConcurrentLinkedQueue<Employee> freeEmployee) {
        this.freeEmployee = freeEmployee;
    }

    @Override
    public Employee getEmployeeFromFreeEmployees(UUID uuid) {
        for (Employee e : freeEmployee) {
            if (e.getId().equals(uuid))
                return e;
        }
        return null;
    }

    @Override
    public Boolean isOpened() {
        return !employeeUtils.getAllEmployees().isEmpty();
    }

    public Boolean isSpaceForCarInWorkshop(Vehicle vehicle) {
        return (vehicle instanceof StandardVehicle && verifyMaximumStandardVehicles()) ||
                (vehicle instanceof BusVehicle && verifyMaximumBusVehicles()) ||
                (vehicle instanceof TruckVehicle && verifyMaximumTruckVehicles());
    }

    public void assignEmployee(Vehicle vehicle, Employee employee) {
        Optional<Job> optionalJob = Optional.of(new Job(employee, vehicle));
        employeeWorkingAtAVehicle.put(employee, optionalJob.get());
        freeEmployee.remove(employee);
        optionalJob.get().startJob();
    }

    @Override
    public Boolean addVehicle(Vehicle vehicle, Optional<UUID> id) {

        if (id != null) {
            Optional<Employee> optionalEmployee = Optional.ofNullable(getEmployeeFromFreeEmployees(id.get()));
            if (isSpaceForCarInWorkshop(vehicle)) {
                if(optionalEmployee.isPresent()) {
                    if (freeEmployee.contains(optionalEmployee.get())) {
                        assignEmployee(vehicle, optionalEmployee.get());
                        return true;
                    } else {
                        System.out.println("Angajatul cu id-ul " + id + " nu este liber.");
                        return false;
                    }
                }
            }
        } else {
            if (isSpaceForCarInWorkshop(vehicle)) {
                if (!freeEmployee.isEmpty()) {
                    Optional<Employee> optionalEmployee = Optional.ofNullable(freeEmployee.peek());
                    assignEmployee(vehicle, optionalEmployee.get());
                    return true;
                } else {
                    System.out.println("Nu este nici un angajat liber pentru masina dumneavoastra.");
                    return false;
                }
            }
        }
        System.out.println("Nu este loc liber in atelier pentru vehicul.");
        return false;
    }

    @Override
    public void addVehicleToQueue(Vehicle vehicle) {
        waitingVehicles.add(new Job(null, vehicle));
    }

    @Override
    public void addVehicleToQueue(Vehicle vehicle, Employee employee) {
        waitingVehicles.add(new Job(employee, vehicle));
    }

    @Override
    public void addVehicleToWaitingList(Vehicle vehicle, Optional<UUID> uuid) {

        UUID id = uuid.isPresent() ? uuid.get() : null;

        if (id != null) {
            Optional<Employee> optionalEmployee = Optional.ofNullable(getEmployeeFromFreeEmployees(id));
            addVehicleToQueue(vehicle, optionalEmployee.get());
            System.out.println("V-am adaugam pe lista de asteptare.");
        } else {
            addVehicleToQueue(vehicle);
            System.out.println("V-am adaugam pe lista de asteptare.");
        }

    }

    @Override
    public Boolean verifyMaximumStandardVehicles() {

        int numberOfStandardVehicles = 0;

        for (Map.Entry<Employee, Job> entry : employeeWorkingAtAVehicle.entrySet()) {
            if (entry.getValue().getVehicle() instanceof StandardVehicle) {
                numberOfStandardVehicles++;
            }
        }
        return numberOfStandardVehicles < 3;
    }

    @Override
    public Boolean verifyMaximumBusVehicles() {
        int numberOfBusVehicles = 0;

        for (Map.Entry<Employee, Job> entry : employeeWorkingAtAVehicle.entrySet()) {
            if (entry.getValue().getVehicle() instanceof BusVehicle) {
                numberOfBusVehicles++;
            }
        }
        return numberOfBusVehicles < 1;
    }

    @Override
    public Boolean verifyMaximumTruckVehicles() {
        int numberOfTruckVehicles = 0;

        for (Map.Entry<Employee, Job> entry : employeeWorkingAtAVehicle.entrySet()) {
            if (entry.getValue().getVehicle() instanceof TruckVehicle) {
                numberOfTruckVehicles++;
            }
        }
        return numberOfTruckVehicles < 1;
    }

    @Override
    public void removeVehicleFromWorkshopIfJobDone() {
        while (true) {
            for (Map.Entry<Employee, Job> entry : employeeWorkingAtAVehicle.entrySet()) {
                if ((entry.getValue().isJobDone())) {
                    freeEmployee.add(entry.getKey());
                    employeeWorkingAtAVehicle.remove(entry.getKey());
                    System.out.println(freeEmployee.toString());
                    System.out.println("Am sters vehiculul cu id-ul ." + entry.getValue().getVehicle().getId());
                    break;
                }
            }
        }
    }

    @Override
    public void assignFreeEmployeeToAVehicleFromWaitingList() {
        while (true) {
                for (Employee e : freeEmployee) {
                    for (Job j : waitingVehicles) {
                        Optional<Employee> optionalEmployee = Optional.ofNullable(j.getEmployee());
                        if (isSpaceForCarInWorkshop(j.getVehicle())) {
                            if(j.getEmployee() == null || (j.getEmployee().getId().equals(e.getId()))) {
                                    assignEmployee(j.getVehicle(), e);
                                    waitingVehicles.remove(j);
                                } else {

                            }
                            } else {
                            System.out.println("Nu exista spatiu pentru acest tip de autoturism.");
                        }
                        }
                }
            }
        }
    }


