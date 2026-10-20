package PracticeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 3: Library Late Fine Counter
 * Demonstrates Abstraction with Abstract Class LibraryItem.
 */
abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateFine();

    public void displayFine() {
        System.out.printf("%s: %.2f%n", title, calculateFine());
    }
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.00;
    }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(50.00, daysLate * 5.00);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.00;
    }
}

public class LibraryLateFineCounter {
    public static void processFines(List<LibraryItem> items) {
        double totalFines = 0;
        for (LibraryItem item : items) {
            item.displayFine();
            totalFines += item.calculateFine();
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
    }

    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new BookItem("Algebra", 4));
        items.add(new DvdItem("Inception", 12));
        items.add(new MagazineItem("Sports", 3));

        processFines(items);
    }
}
