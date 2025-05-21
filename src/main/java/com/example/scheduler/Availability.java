package com.example.scheduler;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Availability {
    //Availability attributes
    private DayOfWeek day;
    private LocalTime startTime;
    private LocalTime endTime;

    //Availability constructor
    public Availability(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //Getters and setters
    public DayOfWeek getDay() {
        return day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getTotalHours(){
        return endTime.getHour() - startTime.getHour();
    }
} //end availability class

