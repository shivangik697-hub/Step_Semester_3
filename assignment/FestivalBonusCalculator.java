package AssignmentProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 4: The Festival Bonus Calculator
 * Demonstrates OOP Polymorphism for employee bonus calculations.
 */
abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();

    public void displayBonus() {
        System.out.printf("%s: %.2f%n", name, calculateBonus());
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.00;
    }
}

public class FestivalBonusCalculator {
    public static void processEmployees(List<Employee> employees) {
        double grandTotal = 0;
        for (Employee e : employees) {
            e.displayBonus();
            grandTotal += e.calculateBonus();
        }
        System.out.printf("Total Bonus: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("Asha", 50000));
        employees.add(new PartTimeEmployee("Ravi", 30000));
        employees.add(new InternEmployee("Neha", 15000));

        processEmployees(employees);
    }
}
