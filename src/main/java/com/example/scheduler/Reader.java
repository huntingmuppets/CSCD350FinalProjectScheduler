package com.example.scheduler;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Reader {
    Scanner scanner;
    ArrayList<Role> roles;

    public ArrayList<Employee> readEmployees(File file) throws IOException {
        scanner = new Scanner(file);
        ArrayList<Employee> employees = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String firstName = line.substring(0, line.indexOf(" "));
            line = line.substring(line.indexOf(" ") + 1);

            String lastName = line.substring(0, line.indexOf(" "));
            line = line.substring(line.indexOf(" ") + 1);

            int maxHours = Integer.parseInt(line.substring(0, line.indexOf(" ")));
            line = line.substring(line.indexOf(" ") + 1);

            LocalDate hireDate = LocalDate.parse(line.substring(0, line.indexOf(" ")));
            line = line.substring(line.indexOf(" ") + 1);

            List<Availability> availability = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                DayOfWeek day = DayOfWeek.valueOf(line.substring(0, line.indexOf(" ")));

                line = line.substring(line.indexOf(" ") + 1);

                LocalTime start = LocalTime.parse(line.substring(0, line.indexOf(" ")));
                line = line.substring(line.indexOf(" ") + 1);

                LocalTime end = LocalTime.parse(line.substring(0, line.indexOf(" ")));
                line = line.substring(line.indexOf(" ") + 1);

                availability.add(new Availability(day, start, end));
            }

            ArrayList<Role> roles = new ArrayList<>();
            line = line.substring(line.indexOf("^") + 1);
            while (line.indexOf("^") != -1) {
                String roleName = line.substring(0, line.indexOf("^"));
                roles.add(getRole(roleName));
                line = line.substring(line.indexOf("^") + 1);
            }

            line = line.substring(line.indexOf(" ") + 1);
            int id = Integer.parseInt(line);
            employees.add(new Employee(firstName, lastName, maxHours, hireDate, availability, roles, id));
        }
        return employees;
    }

    public ArrayList<Role> readRoles(File file) throws IOException {
        scanner = new Scanner(file);
        roles = new ArrayList<>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String name = line.substring(0, line.lastIndexOf(" "));
            line = line.substring(line.lastIndexOf(" ") + 1);
            int id = Integer.parseInt(line);
            roles.add(new Role(name, id));
        }
        return roles;
    }

    public ArrayList<Shift> readShifts(File file) throws IOException {
        scanner = new Scanner(file);
        ArrayList<Shift> shifts = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            DayOfWeek shiftDay = DayOfWeek.valueOf(line.substring(0, line.indexOf(" ")));
            line = line.substring(line.indexOf(" ") + 1);

            LocalTime startTime = LocalTime.parse(line.substring(0, line.indexOf(" ")));
            line = line.substring(line.indexOf(" ") + 1);

            LocalTime endTime = LocalTime.parse(line.substring(0, line.indexOf(" ")));
            line = line.substring(line.indexOf(" ") + 1);

            int minimumShiftLength = Integer.parseInt(line.substring(0, line.indexOf(" ")));
            line = line.substring(line.indexOf(" ") + 1);

            int maximumShiftLength = Integer.parseInt(line.substring(0, line.indexOf(" ")));
            line = line.substring(line.indexOf(" ") + 1);

            line = line.substring(line.indexOf("^") + 1);
            ArrayList<Role> neededRoles = new ArrayList<>();
            while (line.indexOf("^") != -1) {
                String roleName = line.substring(0, line.indexOf("^"));
                neededRoles.add(getRole(roleName));
                line = line.substring(line.indexOf("^") + 1);
            }

            //read in the date of the shift
            int dayOfTheYear = Integer.parseInt(line.substring(0, line.indexOf(" ")));
            Calendar shiftDate = Calendar.getInstance();
            shiftDate.set(Calendar.DAY_OF_YEAR, dayOfTheYear);
            line = line.substring(line.indexOf(" ") + 1);
            int id = Integer.parseInt(line);

            //Shift(DayOfWeek shiftDay,LocalTime startTime,LocalTime endTime, int minimumShiftLength, int maximumShiftLength, ArrayList<Role> neededRoles, Calendar shiftDate)
            Shift shift = new Shift(shiftDay, startTime, endTime, minimumShiftLength, maximumShiftLength, neededRoles, shiftDate);
            shift.setEmployeeID(id);
            shifts.add(shift);
        }
        return shifts;
    }


    public Role getRole(String name) {
        for (Role r : roles) {
            if (r.getName().equals(name)) {
                return r;
            }
        }
        return null;
    }
}
