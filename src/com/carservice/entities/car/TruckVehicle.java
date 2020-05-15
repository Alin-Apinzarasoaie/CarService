package com.carservice.entities.car;

import java.time.LocalDate;

public class TruckVehicle extends Vehicle{

    private static final int TRUCK_VEHICLE_INSURANCE_ADDITION = 300;
    private static final int TRUCK_VEHICLE_INSURANCE_MAX_KILOMETERS_ADDITION = 700;
    private static final int TRUCK_VEHICLE_INSURANCE_MAX_KILOMETERS = 800000;
    private static final int TRUCK_VEHICLE_INSURANCE_DISCOUNT = 15;

    private Integer tonnage;

    public TruckVehicle(Integer numberOfKilometers, Integer fabricationYear, boolean isDiesel, Integer tonnage) {
        super(numberOfKilometers, fabricationYear, isDiesel);
        this.tonnage = tonnage;
    }

    public Integer getTonnage() {
        return tonnage;
    }

    public void setTonnage(Integer tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public Integer calculateInsurancePolicy() {
        LocalDate now = LocalDate.now();
        int yearNow = now.getYear();

        int eldery = yearNow - super.getFabricationYear();

        eldery *= TRUCK_VEHICLE_INSURANCE_ADDITION;

        if(super.getNumberOfKilometers() > TRUCK_VEHICLE_INSURANCE_MAX_KILOMETERS)
            eldery += TRUCK_VEHICLE_INSURANCE_MAX_KILOMETERS_ADDITION;

        return eldery;
    }

    @Override
    public Integer calculateInsurancePolicy(boolean discount) {
        if(discount) return calculateInsurancePolicy() - ((TRUCK_VEHICLE_INSURANCE_DISCOUNT * calculateInsurancePolicy()) / 100);
        else return null;
    }

    @Override
    public String toString() {
        return "TruckVehicle{" +
                "tonnage=" + tonnage +
                '}' + super.toString();
    }
}
