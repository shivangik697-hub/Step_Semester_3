package AssignmentProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 4: City Cab Fare Meter
 * Demonstrates Interfaces (NightServiceable) for conditional night fares.
 */
interface NightServiceable {
    double applyNightSurcharge(double baseFare);
}

class TripRequest {
    private String cabType;
    private double distanceKm;
    private boolean isNight;

    public TripRequest(String cabType, double distanceKm, boolean isNight) {
        this.cabType = cabType;
        this.distanceKm = distanceKm;
        this.isNight = isNight;
    }

    public String getCabType() { return cabType; }
    public double getDistanceKm() { return distanceKm; }
    public boolean isNight() { return isNight; }
}

abstract class Cab {
    protected static final double MINIMUM_FARE = 100.00;

    public abstract String getType();
    public abstract double getRatePerKm();

    public double calculateBaseFare(double distanceKm) {
        double fare = distanceKm * getRatePerKm();
        return Math.max(MINIMUM_FARE, fare);
    }
}

class MiniCab extends Cab {
    @Override
    public String getType() { return "MINI"; }

    @Override
    public double getRatePerKm() { return 10.00; }
}

class SedanCab extends Cab implements NightServiceable {
    @Override
    public String getType() { return "SEDAN"; }

    @Override
    public double getRatePerKm() { return 14.00; }

    @Override
    public double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }
}

class SUVCab extends Cab implements NightServiceable {
    @Override
    public String getType() { return "SUV"; }

    @Override
    public double getRatePerKm() { return 18.00; }

    @Override
    public double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void processTrips(List<TripRequest> requests) {
        double totalCollected = 0;

        for (TripRequest req : requests) {
            Cab cab = null;
            if (req.getCabType().equalsIgnoreCase("MINI")) cab = new MiniCab();
            else if (req.getCabType().equalsIgnoreCase("SEDAN")) cab = new SedanCab();
            else if (req.getCabType().equalsIgnoreCase("SUV")) cab = new SUVCab();

            if (cab == null) continue;

            if (req.isNight() && !(cab instanceof NightServiceable)) {
                System.out.printf("%s: night service not available%n", cab.getType());
            } else {
                double fare = cab.calculateBaseFare(req.getDistanceKm());
                if (req.isNight() && cab instanceof NightServiceable) {
                    fare = ((NightServiceable) cab).applyNightSurcharge(fare);
                }
                System.out.printf("%s: %.2f%n", cab.getType(), fare);
                totalCollected += fare;
            }
        }
        System.out.printf("Total: %.2f%n", totalCollected);
    }

    public static void main(String[] args) {
        List<TripRequest> requests = new ArrayList<>();
        requests.add(new TripRequest("MINI", 8, false));
        requests.add(new TripRequest("SEDAN", 10, true));
        requests.add(new TripRequest("SUV", 20, false));
        requests.add(new TripRequest("MINI", 5, true));

        processTrips(requests);
    }
}
