package PracticeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 5: Travel Booking with a Common Fee
 * Demonstrates Abstraction with Base Class TravelBooking encapsulating common booking fee.
 */
abstract class TravelBooking {
    protected double distanceKm;
    protected static final double BOOKING_FEE = 50.00;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract String getMode();
    public abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }

    public void displayFare() {
        System.out.printf("%s: %.2f%n", getMode(), calculateTotalFare());
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "BUS";
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.00;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.50;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }

    @Override
    public double calculateBaseFare() {
        return 2500.00 + (distanceKm * 4.00);
    }
}

public class TravelBookingCommonFee {
    public static void processBookings(List<TravelBooking> bookings) {
        for (TravelBooking booking : bookings) {
            booking.displayFare();
        }
    }

    public static void main(String[] args) {
        List<TravelBooking> bookings = new ArrayList<>();
        bookings.add(new BusBooking(200));
        bookings.add(new TrainBooking(300));
        bookings.add(new FlightBooking(500));

        processBookings(bookings);
    }
}
