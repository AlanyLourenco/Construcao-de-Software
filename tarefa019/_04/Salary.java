package org.example._04;

public class Employee {
    private double salary;
    private double awards;

    public void employeeMethod(Employee employee) {
        // Some actions
        double yearlySalary = employee.getYearlySalary();
        double employeeAwards = employee.getAwards();
        double monthlySalary = getMonthlySalary(yearlySalary, employeeAwards);
        // Continue processing
    }

    public double getYearlySalary() {
        return salary * 12;
    }

    public double getAwards() {
        return awards;
    }

    public double getMonthlySalary() {
        double yearlySalary = getYearlySalary();
        return (yearlySalary + awards) / 12;
    }
}

