package PracticeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 3: Delivery Fee Calculator
 * Demonstrates OOP Polymorphism for delivery fee calculation based on weight, distance, and customs.
 */
abstract class DeliveryRequest {
    protected double weight;
    protected double distance;

    public DeliveryRequest(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract String getDeliveryType();
    public abstract double calculateFee();

    public void displayFee() {
        System.out.printf("%s: %.2f%n", getDeliveryType(), calculateFee());
    }
}

class StandardDelivery extends DeliveryRequest {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public String getDeliveryType() {
        return "STANDARD";
    }

    @Override
    public double calculateFee() {
        return 5.00 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends DeliveryRequest {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public String getDeliveryType() {
        return "EXPRESS";
    }

    @Override
    public double calculateFee() {
        return 15.00 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends DeliveryRequest {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public String getDeliveryType() {
        return "INTERNATIONAL";
    }

    @Override
    public double calculateFee() {
        return 25.00 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class DeliveryFeeCalculator {
    public static void processDeliveries(List<DeliveryRequest> deliveries) {
        double grandTotal = 0;
        for (DeliveryRequest delivery : deliveries) {
            delivery.displayFee();
            grandTotal += delivery.calculateFee();
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        List<DeliveryRequest> deliveries = new ArrayList<>();
        deliveries.add(new StandardDelivery(10, 50));
        deliveries.add(new ExpressDelivery(5, 20));
        deliveries.add(new InternationalDelivery(20, 100, 30));

        processDeliveries(deliveries);
    }
}
