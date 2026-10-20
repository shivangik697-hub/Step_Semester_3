package PracticeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 5: Public Transport Fare Calculator
 * Demonstrates OOP Polymorphism for public transport fare calculations.
 */
abstract class Journey {
    protected double distance;

    public Journey(double distance) {
        this.distance = distance;
    }

    public abstract String getTransportType();
    public abstract double calculateFare();

    public void displayFare() {
        System.out.printf("%s: %.2f%n", getTransportType(), calculateFare());
    }
}

class BusJourney extends Journey {
    public BusJourney(double distance) {
        super(distance);
    }

    @Override
    public String getTransportType() {
        return "BUS";
    }

    @Override
    public double calculateFare() {
        return Math.min(10.0, 2.0 + (0.10 * distance));
    }
}

class TrainJourney extends Journey {
    public TrainJourney(double distance) {
        super(distance);
    }

    @Override
    public String getTransportType() {
        return "TRAIN";
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroJourney extends Journey {
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public String getTransportType() {
        return "METRO";
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class TransportFareCalculator {
    public static void processJourneys(List<Journey> journeys) {
        double grandTotal = 0;
        for (Journey journey : journeys) {
            journey.displayFare();
            grandTotal += journey.calculateFare();
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        List<Journey> journeys = new ArrayList<>();
        journeys.add(new BusJourney(15));
        journeys.add(new TrainJourney(50));
        journeys.add(new MetroJourney(10, 1.5));

        processJourneys(journeys);
    }
}
