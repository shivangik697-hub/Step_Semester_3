package AssignmentProblem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem 5: The Streaming Plan Renewal Reminder
 * Demonstrates OOP Polymorphism for subscription plan renewal calculations.
 */
abstract class StreamingPlan {
    protected String name;
    protected LocalDate startDate;

    public StreamingPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract int getValidityDays();

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }

    public void displayRenewal() {
        System.out.println(name + ": " + calculateRenewalDate());
    }
}

class BasicPlan extends StreamingPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends StreamingPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends StreamingPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {
    public static void processSubscribers(List<StreamingPlan> subscribers) {
        for (StreamingPlan sub : subscribers) {
            sub.displayRenewal();
        }
    }

    public static void main(String[] args) {
        List<StreamingPlan> subscribers = new ArrayList<>();
        subscribers.add(new BasicPlan("Asha", LocalDate.of(2024, 1, 15)));
        subscribers.add(new StandardPlan("Ravi", LocalDate.of(2024, 2, 1)));
        subscribers.add(new PremiumPlan("Neha", LocalDate.of(2024, 3, 10)));
        subscribers.add(new BasicPlan("Kiran", LocalDate.of(2024, 12, 20)));

        processSubscribers(subscribers);
    }
}
