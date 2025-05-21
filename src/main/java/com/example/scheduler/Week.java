package com.example.scheduler;

public class Week {
    private Day currentDay;

    private int employeeWeeklyHours;

    public Week(Day currentDay, int employeeWeeklyHours) {
        this.currentDay = currentDay;
        this.employeeWeeklyHours = employeeWeeklyHours;
    }

    public Day getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(Day currentDay) {
        this.currentDay = currentDay;
    }

    public int getEmployeeWeeklyHours() {
        return employeeWeeklyHours;
    }

    public void setEmployeeWeeklyHours(int employeeWeeklyHours) {
        this.employeeWeeklyHours = employeeWeeklyHours;
    }
}
