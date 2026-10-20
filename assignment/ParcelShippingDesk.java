package AssignmentProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 2: Parcel Shipping Desk
 * Demonstrates Interfaces (Insurable) for optional capabilities.
 */
interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract String getType();
    public abstract double calculateShippingCharge();

    public double getInsuranceAmount() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance(declaredValue);
        }
        return 0.00;
    }

    public double calculateTotalCost() {
        return calculateShippingCharge() + getInsuranceAmount();
    }

    public void displayParcelInfo() {
        System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                getType(), calculateShippingCharge(), getInsuranceAmount(), calculateTotalCost());
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }

    @Override
    public double calculateShippingCharge() {
        return 40.00 + (10.00 * weightKg);
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }

    @Override
    public double calculateShippingCharge() {
        return 80.00 + (15.00 * weightKg);
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public String getType() {
        return "FRAGILE";
    }

    @Override
    public double calculateShippingCharge() {
        return (40.00 + (10.00 * weightKg)) + 50.00;
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void processParcels(List<Parcel> parcels) {
        double grandTotal = 0;
        for (Parcel p : parcels) {
            p.displayParcelInfo();
            grandTotal += p.calculateTotalCost();
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new StandardParcel(3, 500));
        parcels.add(new ExpressParcel(2, 1000));
        parcels.add(new FragileParcel(4, 2000));

        processParcels(parcels);
    }
}
