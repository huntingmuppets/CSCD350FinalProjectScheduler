package com.example.scheduler;

import java.time.LocalTime;
import java.util.ArrayList;

public class Day {
    //Day attributes
    private ArrayList shiftArrayList;

    private LocalTime[] workingHours;

    //Day constructor
    public Day(ArrayList shiftArrayList, LocalTime[] workingHours) {
        this.shiftArrayList = shiftArrayList;
        this.workingHours = workingHours;
    }

    //Getters and setters
    public ArrayList getShiftArrayList() {
        return shiftArrayList;
    }

    public LocalTime[] getWorkingHours() {
        return workingHours;
    }

    public void setShiftArray(ArrayList shiftArrayList) {
        this.shiftArrayList = shiftArrayList;
    }

    public void setWorkingHours(LocalTime[] workingHours) {
        this.workingHours = workingHours;
    }
}
