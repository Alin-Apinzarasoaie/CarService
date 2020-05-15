package com.carservice.entities.Job;

import com.carservice.entities.car.Vehicle;
import com.carservice.entities.employee.Employee;

import java.time.LocalDateTime;
import java.util.Random;

public class Job implements IJob{

    private Employee employee;

    private Vehicle vehicle;

    private LocalDateTime startJobTime;

    private LocalDateTime endJobTime;

    public Job(Employee employee, Vehicle vehicle) {
        this.employee = employee;
        this.vehicle = vehicle;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getStartJobTime() {
        return startJobTime;
    }

    public void setStartJobTime(LocalDateTime startJobTime) {
        this.startJobTime = startJobTime;
    }

    public LocalDateTime getEndJobTime() {
        return endJobTime;
    }

    public void setEndJobTime(LocalDateTime endJobTime) {
        this.endJobTime = endJobTime;
    }

    @Override
    public void startJob() {
        this.startJobTime = LocalDateTime.now();
        int randomTimeToFinishJob = getRandomNumberInRange(10 , 20);

        this.endJobTime = startJobTime.plusSeconds(randomTimeToFinishJob);
    }

    @Override
    public int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }

    @Override
    public Boolean isJobDone() {
        if(endJobTime == null)
            return false;
        return this.endJobTime.isBefore(LocalDateTime.now());
    }
}
