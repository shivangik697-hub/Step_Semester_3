package AssignmentProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 3: The Hostel Electricity Bill
 * Demonstrates OOP Polymorphism for electricity bill calculation across room types.
 */
abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract String getRoomType();
    public abstract double calculateBill();

    public void displayBill() {
        System.out.printf("%s: %.2f%n", getRoomType(), calculateBill());
    }
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public String getRoomType() {
        return "SINGLE";
    }

    @Override
    public double calculateBill() {
        return units * 8.00;
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public String getRoomType() {
        return "SHARED";
    }

    @Override
    public double calculateBill() {
        return (units * 6.00) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    @Override
    public String getRoomType() {
        return "AC";
    }

    @Override
    public double calculateBill() {
        return (units * 10.00) + 200.00;
    }
}

public class HostelElectricityBill {
    public static void processRooms(List<Room> rooms) {
        double grandTotal = 0;
        for (Room r : rooms) {
            r.displayBill();
            grandTotal += r.calculateBill();
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom(120));
        rooms.add(new SharedRoom(150, 3));
        rooms.add(new ACRoom(100));

        processRooms(rooms);
    }
}
