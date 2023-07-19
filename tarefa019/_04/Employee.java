package org.example._04;

public class Employee {
    private double salary;
    private double awards;

    // Construtor (opcional)
    public Employee(double salary, double awards) {
        this.salary = salary;
        this.awards = awards;
    }

    // Getter para salary
    public double getSalary() {
        return salary;
    }

    // Getter para awards
    public double getAwards() {
        return awards;
    }

    // Setter para salary (opcional, se quiser permitir alterar o salário)
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Método para calcular o salário mensal
    public double getMonthlySalary() {
        double yearlySalary = salary * 12;
        return (yearlySalary + awards) / 12;
    }

    // Método para processar funcionários (opcional, depende do contexto)
    public void processEmployee(Employee employee) {
        // Some actions
        double yearlySalary = employee.getYearlySalary();
        double empAwards = employee.getAwards(); // Renomeado para evitar conflito
        double monthlySalary = getMonthlySalary(yearlySalary, empAwards);
        // Continue processing
    }

    // Método para obter o salário anual
    public double getYearlySalary() {
        return salary * 12;
    }
}
