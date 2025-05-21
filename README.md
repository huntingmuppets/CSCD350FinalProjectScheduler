# Scheduler

Project Version: 0.1.0

Repo: https://github.com/Emblin13/Scheduler/

All source code can be found in the repo above. The source files are located in /src/main/java/com/example/scheduler. 

## **About the Scheduler:**
The Scheduler is a JavaFX application designed to help managers automatically generate schedules for their employees 
based on their availability, max hours, and other details.

## **How to run the program:**
This project is built and compiled using Maven 4.0.0 and IntelliJ IDEA. To install this program, open your preferred IDE
and import this project from VCS. Your device must have Java installed to run the program

 
## **User Instructions:**
**Adding and editing employees:**\
Click "add employee" to create a new employee, or click on an existing Employee's cell to edit their information, then
press "submit". Alternatively, if you would like to delete an employee, hit "delete" instead.

**Adding and editing shifts:**\
Click one of the boxes in the top row to view all schedules assigned to that day. To edit an existing shift, click on
one from this menu, or click on an assigned shift from the rows below. To create a new shift without assigning it, click
on the "add shift" button instead. Alternatively, to create a new shift and immediately assign it to an employee, click
on one of the empty cells and the shift will be added to the employee in that row.

**Adding and editing roles:**\
Click "add role" to create a new role, or click "edit roles" to see all existing roles and select one for editing.

**Generating the schedule:**\
Click "generate schedule" to automatically generate a schedule using information from the employees, current and 
upcoming shifts (including already-assigned ones), along with any other constraints provided by the manager or the
program itself. Caution: manually removed or added shifts will be overwritten by the schedule generator

**Printing the schedule:**\
Click the "print schedule" button, then navigate to \Users\...\Pictures\Schedules to find the PNG screenshot of the
schedule, labelled as "Schedule YYYY-MM-DD.png"

## **Developer Guidelines:**
Beyond the use of IDEs, automated testing was not used in the development of this program. Therefore, there are no tests
included in this program, nor are there any pre-existing conventions that need to be followed. However; for writing new 
tests, we highly recommend the use of TestFX, a testing framework specifically designed for testing JavaFX programs. The
repository for TestFX is located here:
https://github.com/TestFX/TestFX

Since this is a pre-alpha project, and the first build capable of fulfilling most user requirements, the current version
is 0.1.0. Future builds should follow the semantic versioning standard. There are not yet any systems implemented for 
automating build release management.

To avoid unnecessary headaches, extra care should be taken to ensure all JavaFX design
elements display properly on all supported platforms and resolutions. 