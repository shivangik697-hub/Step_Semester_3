package AssignmentProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1: The Canteen Billing Counter
 * Demonstrates OOP Polymorphism for canteen customer billing with distinct pricing rules.
 */
abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract String getCustomerType();
    public abstract double calculateFinalAmount();

    public void displayBill() {
        System.out.printf("%s: %.2f%n", getCustomerType(), calculateFinalAmount());
    }
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "STUDENT";
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90; // 10% discount
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "STAFF";
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95; // 5% discount
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "GUEST";
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.00; // Full amount + ₹10 service charge
    }
}

public class CanteenBillingCounter {
    public static void processBills(List<Customer> customers) {
        double grandTotal = 0;
        for (Customer c : customers) {
            c.displayBill();
            grandTotal += c.calculateFinalAmount();
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new StudentCustomer(200));
        customers.add(new StaffCustomer(300));
        customers.add(new GuestCustomer(150));

        processBills(customers);
    }
}
