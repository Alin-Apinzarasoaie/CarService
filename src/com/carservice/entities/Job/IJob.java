package com.carservice.entities.Job;

public interface IJob {

    void startJob();

    int getRandomNumberInRange(int min, int max);

    Boolean isJobDone();

}
