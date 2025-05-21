package com.example.scheduler;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;

public class Shift
{
    private LocalTime startTime;
    private LocalTime endTime;
    private int minimumShiftLength;
    private int maximumShiftLength;
    private DayOfWeek shiftDay;
    private Calendar shiftDate;
    private ArrayList<Role> neededRoles;
    private boolean isFilled = false;
    private int EmployeeID = -1;

    public Shift(final DayOfWeek shiftDay, final LocalTime startTime, final LocalTime endTime, final int minimumShiftLength, final int maximumShiftLength, final ArrayList<Role> neededRoles, Calendar shiftDate) {
        this.shiftDay = shiftDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.minimumShiftLength = minimumShiftLength;
        this.maximumShiftLength = maximumShiftLength;
        this.neededRoles = neededRoles;
        this.shiftDate = shiftDate;
    }

    //To string method. Converts shift to a string for saving to a file.
    public String toString() {
        String holder = "";
        holder += shiftDay + " " + startTime + " " + endTime + " " + minimumShiftLength + " " + maximumShiftLength + " ^";
        for (int i = 0; i < neededRoles.size(); i++) {
            holder += neededRoles.get(i).getName() + "^";
        }
        holder += shiftDate.get(Calendar.DAY_OF_YEAR) + " " + EmployeeID;
        return holder;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public LocalTime getStartTime()
    {
        return startTime;
    }

    public void setStartTime(LocalTime startTime)
    {
        this.startTime = startTime;
    }

    public LocalTime getEndTime()
    {
        return endTime;
    }

    public void setEndTime(LocalTime endTime)
    {
        this.endTime = endTime;
    }
    public DayOfWeek getShiftDay()
    {
        return shiftDay;
    }

    public void setShiftDay(DayOfWeek shiftDay)
    {
        this.shiftDay = shiftDay;
    }

    public int getMinimumShiftLength()
    {
        return minimumShiftLength;
    }

    public void setMinimumShiftLength(int minimumShiftLength)
    {
        this.minimumShiftLength = minimumShiftLength;
    }

    public int getMaximumShiftLength()
    {
        return maximumShiftLength;
    }

    public void setMaximumShiftLength(int maximumShiftLength)
    {
        this.maximumShiftLength = maximumShiftLength;
    }

    public ArrayList<Role> getNeededRoles() {
        return neededRoles;
    }

    public void setNeededRoles(ArrayList<Role> neededRoles) {
        this.neededRoles = neededRoles;
    }

    public int shiftLength() {
        //Return the length of the shift in hours
        return endTime.getHour() - startTime.getHour();
    }

    public Calendar getShiftDate() {
        return shiftDate;
    }

    //Generates a color based on the shift's hashcode.
    public String getColor() {
        //Get the hashcode of the shift and convert it to a string. Exclude the last word of the string, which is the employee ID.
        String temp = toString().substring(0, toString().lastIndexOf(" "));
        //Makes the color a positive value
        String color = String.valueOf(Math.abs(temp.hashCode()));
        color = String.format("#%6s", color).replace(' ', '0');

        //Get the red, green, and blue values of the color
        String red = color.substring(1, 3);
        //If the color is too dark, make it lighter
        if (Integer.parseInt(red, 16) < 127){
            int redInt = Integer.parseInt(red, 16);
            redInt = 255 - redInt;
            red = Integer.toHexString(redInt);
        } else {
            int redInt = Integer.parseInt(red, 16);
            red = Integer.toHexString(redInt);
        }

        String green = color.substring(3, 5);
        if (Integer.parseInt(green, 16) < 127){
            int greenInt = Integer.parseInt(green, 16);
            greenInt = 255 - greenInt;
            green = Integer.toHexString(greenInt);
        } else {
            int greenInt = Integer.parseInt(green, 16);
            green = Integer.toHexString(greenInt);
        }

        String blue = color.substring(5, 7);
        if (Integer.parseInt(blue, 16) < 127){
            int blueInt = Integer.parseInt(blue, 16);
            blueInt = 255 - blueInt;
            blue = Integer.toHexString(blueInt);
        } else {
            int blueInt = Integer.parseInt(blue, 16);
            blue = Integer.toHexString(blueInt);
        }

        //Recombine the color
        color = "#" + red + green + blue;
        return color;
    }
}
