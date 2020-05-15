package com.carservice.Utils;

import com.carservice.entities.car.Vehicle;

public interface IVehicleUtils {

    void addVehicle(Vehicle vehicle);

    Vehicle getVehicleById(String UUID);

}
