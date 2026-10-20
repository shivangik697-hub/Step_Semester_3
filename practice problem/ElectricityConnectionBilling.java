package PracticeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 4: Electricity Connection Billing
 * Demonstrates Abstraction with Abstract Class Connection.
 */
abstract class Connection {
    protected double units;

    public Connection(double units) {
        this.units = units;
    }

    public abstract String getType();
    public abstract double calculateBill();

    public void displayBill() {
        System.out.printf("%s: %.2f%n", getType(), calculateBill());
    }
}

class HomeConnection extends Connection {
    public HomeConnection(double units) {
        super(units);
    }

    @Override
    public String getType() {
        return "HOME";
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.00;
        } else {
            return (100 * 5.00) + ((units - 100) * 7.00);
        }
    }
}

class ShopConnection extends Connection {
    public ShopConnection(double units) {
        super(units);
    }

    @Override
    public String getType() {
        return "SHOP";
    }

    @Override
    public double calculateBill() {
        return (units * 8.00) + 100.00;
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(double units) {
        super(units);
    }

    @Override
    public String getType() {
        return "FACTORY";
    }

    @Override
    public double calculateBill() {
        return Math.max(1000.00, units * 6.00);
    }
}

public class ElectricityConnectionBilling {
    public static void processConnections(List<Connection> connections) {
        double totalBilled = 0;
        for (Connection conn : connections) {
            conn.displayBill();
            totalBilled += conn.calculateBill();
        }
        System.out.printf("Total: %.2f%n", totalBilled);
    }

    public static void main(String[] args) {
        List<Connection> connections = new ArrayList<>();
        connections.add(new HomeConnection(150));
        connections.add(new ShopConnection(90));
        connections.add(new FactoryConnection(120));

        processConnections(connections);
    }
}
