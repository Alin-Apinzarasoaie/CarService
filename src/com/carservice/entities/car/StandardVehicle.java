package com.carservice.entities.car;


import java.time.LocalDate;

public class StandardVehicle extends Vehicle {

    private static final int STANDARD_VEHICLE_INSURANCE_ADDITION = 100;
    private static final int STANDARD_VEHICLE_INSURANCE_ADDITION_IF_DIESEL_AND_IF_MORE_KILOMETERS = 500;
    private static final int STANDARD_VEHICLE_INSURANCE_MAX_KILOMETERS_ADDITION = 200000;
    private static final int STANDARD_VEHICLE_INSURANCE_DISCOUNT = 5;

    private TransmissionMode transmissionMode;

    public StandardVehicle(Integer numberOfKilometers, Integer fabricationYear, boolean isDiesel, TransmissionMode transmissionMode) {
        super(numberOfKilometers, fabricationYear, isDiesel);
        this.transmissionMode = transmissionMode;
    }

    public TransmissionMode getTransmissionMode() {
        return transmissionMode;
    }

    public void setTransmissionMode(TransmissionMode transmissionMode) {
        this.transmissionMode = transmissionMode;
    }

    @Override
    public Integer calculateInsurancePolicy() {
        LocalDate now = LocalDate.now();
        int yearNow = now.getYear();

        int eldery = yearNow - super.getFabricationYear();

        eldery *= STANDARD_VEHICLE_INSURANCE_ADDITION;

        if(super.isDiesel())
            eldery += STANDARD_VEHICLE_INSURANCE_ADDITION_IF_DIESEL_AND_IF_MORE_KILOMETERS;

        if(super.getNumberOfKilometers() > STANDARD_VEHICLE_INSURANCE_MAX_KILOMETERS_ADDITION)
            eldery += STANDARD_VEHICLE_INSURANCE_ADDITION_IF_DIESEL_AND_IF_MORE_KILOMETERS;

        return eldery;
    }

    @Override
    public Integer calculateInsurancePolicy(boolean discount) {
        if(discount) return calculateInsurancePolicy() - ((STANDARD_VEHICLE_INSURANCE_DISCOUNT * calculateInsurancePolicy()) / 100);
        else return null;
    }

    @Override
    public String toString() {
        return "StandardVehicle{" +
                "transmisionMode=" + transmissionMode +
                '}' + super.toString();
    }


}
