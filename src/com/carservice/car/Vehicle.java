package com.carservice.car;

import java.util.UUID;

public abstract class Vehicle {

    private UUID id;

    private Integer numberOfKilometers;

    private Integer fabricationYear;

    private boolean isDiesel;

    abstract public Integer calculateInsurancePolicy();
    abstract public Integer calculateInsurancePolicy(boolean discount);

    public Vehicle(Integer numberOfKilometers, Integer fabricationYear, boolean isDiesel) {
        this.id = UUID.randomUUID();
        this.numberOfKilometers = numberOfKilometers;
        this.fabricationYear = fabricationYear;
        this.isDiesel = isDiesel;
    }

    public UUID getId() {
        return id;
    }

    public Integer getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public void setNumberOfKilometers(Integer numberOfKilometers) {
        this.numberOfKilometers = numberOfKilometers;
    }

    public Integer getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(Integer fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public boolean isDiesel() {
        return isDiesel;
    }

    public void setDiesel(boolean diesel) {
        isDiesel = diesel;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", nubmerOfKilometers=" + numberOfKilometers +
                ", fabricationYear=" + fabricationYear +
                ", isDiesel=" + isDiesel +
                '}';
    }
}
