package AssignmentProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1: Movie Ticket Counter
 * Demonstrates Abstraction and encapsulation of shared convenience fee.
 */
abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.00;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract String getSeatType();
    public abstract double getTicketPrice();

    public double calculateTotalAmount() {
        return count * (getTicketPrice() + CONVENIENCE_FEE);
    }

    public void displayBooking() {
        System.out.printf("%s: %.2f%n", getSeatType(), calculateTotalAmount());
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }

    @Override
    public double getTicketPrice() {
        return 150.00;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }

    @Override
    public double getTicketPrice() {
        return 250.00;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }

    @Override
    public double getTicketPrice() {
        return 400.00;
    }
}

public class MovieTicketCounter {
    public static void processBookings(List<Ticket> bookings) {
        double grandTotal = 0;
        for (Ticket ticket : bookings) {
            ticket.displayBooking();
            grandTotal += ticket.calculateTotalAmount();
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        List<Ticket> bookings = new ArrayList<>();
        bookings.add(new RegularTicket(3));
        bookings.add(new PremiumTicket(2));
        bookings.add(new ReclinerTicket(1));

        processBookings(bookings);
    }
}
