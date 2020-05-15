package com.carservice.entities.workshop;

import com.carservice.entities.car.Vehicle;
import com.carservice.entities.employee.Employee;
import com.carservice.entities.workshop.Workshop;

import java.util.Optional;
import java.util.UUID;

public interface IWorkshop {

    Employee getEmployeeFromFreeEmployees(UUID uuid);

    Boolean isOpened();

    void addVehicleToQueue(Vehicle vehicle);

    void addVehicleToQueue(Vehicle vehicle, Employee employee);

    void addVehicleToWaitingList(Vehicle vehicle, Optional<UUID> uuid);

    Boolean verifyMaximumStandardVehicles();

    Boolean verifyMaximumBusVehicles();

    Boolean verifyMaximumTruckVehicles();

    void removeVehicleFromWorkshopIfJobDone();

    void assignFreeEmployeeToAVehicleFromWaitingList();

    Boolean isSpaceForCarInWorkshop(Vehicle vehicle);

    void assignEmployee(Vehicle vehicle, Employee employee);

    Boolean addVehicle(Vehicle vehicle, Optional<UUID> uuid);
}
