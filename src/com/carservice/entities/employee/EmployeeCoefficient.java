package com.carservice.entities.employee;

final class EmployeeCoefficient {

    static final double DIRECTOR_COEFFICIENT = 2;
    static final double MECHANIC_COEFFICIENT = 1.5;
    static final double ASSISTENT_COEFFICIENT = 1;

    private EmployeeCoefficient() {

        throw new AssertionError();
    }
}
