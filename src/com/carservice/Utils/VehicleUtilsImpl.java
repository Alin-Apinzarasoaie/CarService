package com.carservice.Utils;

import com.carservice.entities.car.Vehicle;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.UUID;

public class VehicleUtilsImpl implements IVehicleUtils {

    private PriorityQueue<Vehicle> allVehicles = new PriorityQueue<>();

    @Override
    public void addVehicle(Vehicle vehicle) {
        allVehicles.add(vehicle);
    }

    @Override
    public Vehicle getVehicleById(String uuid) {

        for(Vehicle v : allVehicles) {
            if(v.getId().equals(UUID.fromString(uuid))) return v;
        }

        System.out.println("Nu am putut gasi vehiculul cu id-ul: " + uuid);
        return null;
    }
}
