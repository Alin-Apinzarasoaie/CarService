package com.carservice.car;

import java.time.LocalDate;

public class BusVehicle extends Vehicle {

    private static final int BUS_VEHICLE_INSURANCE_ADDITION = 200;
    private static final int BUS_VEHICLE_INSURANCE_ADDITION_IF_DIESEL_AND_IF_MORE_KILOMETERS = 1000;
    private static final int BUS_VEHICLE_INSURANCE_ADDITION_FOR_MIN_KILOMETERS = 500;
    private static final int BUS_VEHICLE_INSURANCE_MIN_KILOMETERS_FOR_ADDITION = 100000;
    private static final int BUS_VEHICLE_INSURANCE_MAX_KILOMETERS_FOR_ADDITION = 200000;
    private static final int BUS_VEHICLE_INSURANCE_DISCOUNT = 10;

    private Integer numberOfSeats;

    public BusVehicle(Integer numberOfKilometers, Integer fabricationYear, boolean isDiesel, Integer numberOfSeats) {
        super(numberOfKilometers, fabricationYear, isDiesel);
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public Integer calculateInsurancePolicy() {
        LocalDate now = LocalDate.now();
        int yearNow = now.getYear();

        int eldery = yearNow - super.getFabricationYear();

        eldery *= BUS_VEHICLE_INSURANCE_ADDITION;

        if(super.isDiesel())
            eldery += BUS_VEHICLE_INSURANCE_ADDITION_IF_DIESEL_AND_IF_MORE_KILOMETERS;

        if(super.getNumberOfKilometers() < BUS_VEHICLE_INSURANCE_MAX_KILOMETERS_FOR_ADDITION || super.getNumberOfKilometers() > BUS_VEHICLE_INSURANCE_MIN_KILOMETERS_FOR_ADDITION)
            eldery += BUS_VEHICLE_INSURANCE_ADDITION_FOR_MIN_KILOMETERS;

        else if(super.getNumberOfKilometers() > BUS_VEHICLE_INSURANCE_MAX_KILOMETERS_FOR_ADDITION)
            eldery += BUS_VEHICLE_INSURANCE_ADDITION_IF_DIESEL_AND_IF_MORE_KILOMETERS;

        return eldery;
    }

    @Override
    public Integer calculateInsurancePolicy(boolean discount) {
        if(discount) return ((BUS_VEHICLE_INSURANCE_DISCOUNT * calculateInsurancePolicy()) / 100);
        else return null;
    }

    @Override
    public String toString() {
        return "BusVehicle{" +
                "nubmerOfSeats=" + numberOfSeats +
                '}' + super.toString();
    }
}
