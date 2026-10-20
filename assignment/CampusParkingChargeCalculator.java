package AssignmentProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 2: The Campus Parking Charge Calculator
 * Demonstrates OOP Polymorphism for vehicle parking charges.
 */
abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract String getVehicleType();
    public abstract double calculateCharge();

    public void displayCharge() {
        System.out.printf("%s: %.2f%n", getVehicleType(), calculateCharge());
    }
}

class BikeVehicle extends Vehicle {
    public BikeVehicle(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "BIKE";
    }

    @Override
    public double calculateCharge() {
        return hours * 10.00;
    }
}

class CarVehicle extends Vehicle {
    public CarVehicle(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "CAR";
    }

    @Override
    public double calculateCharge() {
        return 30.00 + (hours - 1) * 20.00;
    }
}

class TruckVehicle extends Vehicle {
    public TruckVehicle(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "TRUCK";
    }

    @Override
    public double calculateCharge() {
        return Math.max(100.00, hours * 50.00);
    }
}

public class CampusParkingChargeCalculator {
    public static void processParkedVehicles(List<Vehicle> vehicles) {
        double grandTotal = 0;
        for (Vehicle v : vehicles) {
            v.displayCharge();
            grandTotal += v.calculateCharge();
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new BikeVehicle(3));
        vehicles.add(new CarVehicle(4));
        vehicles.add(new TruckVehicle(1));
        vehicles.add(new CarVehicle(1));

        processParkedVehicles(vehicles);
    }
}
