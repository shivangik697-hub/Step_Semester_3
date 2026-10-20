package AssignmentProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 5: Home Appliance Energy Report
 * Demonstrates Interface (SaverModeCapable) for energy reduction.
 */
interface SaverModeCapable {
    double applySaverMode(double baseUnits);
}

class ApplianceRequest {
    private String applianceType;
    private double hours;
    private boolean isSaverRequested;

    public ApplianceRequest(String applianceType, double hours, boolean isSaverRequested) {
        this.applianceType = applianceType;
        this.hours = hours;
        this.isSaverRequested = isSaverRequested;
    }

    public String getApplianceType() { return applianceType; }
    public double getHours() { return hours; }
    public boolean isSaverRequested() { return isSaverRequested; }
}

abstract class Appliance {
    public abstract String getName();
    public abstract double getPowerRatingWatts();

    public double calculateBaseUnits(double hours) {
        return (getPowerRatingWatts() * hours) / 1000.0;
    }

    public double calculateCost(double units) {
        return units * 8.00;
    }
}

class FridgeAppliance extends Appliance {
    @Override public String getName() { return "FRIDGE"; }
    @Override public double getPowerRatingWatts() { return 150.0; }
}

class ACAppliance extends Appliance implements SaverModeCapable {
    @Override public String getName() { return "AC"; }
    @Override public double getPowerRatingWatts() { return 1500.0; }

    @Override
    public double applySaverMode(double baseUnits) {
        return baseUnits * 0.75;
    }
}

class TVAppliance extends Appliance {
    @Override public String getName() { return "TV"; }
    @Override public double getPowerRatingWatts() { return 100.0; }
}

class WasherAppliance extends Appliance implements SaverModeCapable {
    @Override public String getName() { return "WASHER"; }
    @Override public double getPowerRatingWatts() { return 500.0; }

    @Override
    public double applySaverMode(double baseUnits) {
        return baseUnits * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void generateReport(List<ApplianceRequest> requests) {
        double totalCost = 0;

        for (ApplianceRequest req : requests) {
            Appliance appliance = null;
            if (req.getApplianceType().equalsIgnoreCase("FRIDGE")) appliance = new FridgeAppliance();
            else if (req.getApplianceType().equalsIgnoreCase("AC")) appliance = new ACAppliance();
            else if (req.getApplianceType().equalsIgnoreCase("TV")) appliance = new TVAppliance();
            else if (req.getApplianceType().equalsIgnoreCase("WASHER")) appliance = new WasherAppliance();

            if (appliance == null) continue;

            if (req.isSaverRequested() && !(appliance instanceof SaverModeCapable)) {
                System.out.printf("%s: saver mode not supported%n", appliance.getName());
            } else {
                double units = appliance.calculateBaseUnits(req.getHours());
                if (req.isSaverRequested() && appliance instanceof SaverModeCapable) {
                    units = ((SaverModeCapable) appliance).applySaverMode(units);
                }
                double cost = appliance.calculateCost(units);
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.getName(), units, cost);
                totalCost += cost;
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }

    public static void main(String[] args) {
        List<ApplianceRequest> requests = new ArrayList<>();
        requests.add(new ApplianceRequest("FRIDGE", 24, false));
        requests.add(new ApplianceRequest("AC", 8, true));
        requests.add(new ApplianceRequest("TV", 5, false));
        requests.add(new ApplianceRequest("WASHER", 2, true));

        generateReport(requests);
    }
}
