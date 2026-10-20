package PracticeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 2: Weekly Staff Pay
 * Demonstrates Abstraction with Abstract Class StaffMember.
 */
abstract class StaffMember {
    protected String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePay();

    public void displayPay() {
        System.out.printf("%s: %.2f%n", name, calculatePay());
    }
}

class FullTimeStaff extends StaffMember {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * 1.5 * rate);
        }
    }
}

class InternStaff extends StaffMember {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void processPayroll(List<StaffMember> staffList) {
        double totalPayroll = 0;
        for (StaffMember staff : staffList) {
            staff.displayPay();
            totalPayroll += staff.calculatePay();
        }
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
    }

    public static void main(String[] args) {
        List<StaffMember> staffList = new ArrayList<>();
        staffList.add(new FullTimeStaff("Asha", 12000));
        staffList.add(new HourlyStaff("Ravi", 45, 200));
        staffList.add(new InternStaff("Neha", 5000));

        processPayroll(staffList);
    }
}
