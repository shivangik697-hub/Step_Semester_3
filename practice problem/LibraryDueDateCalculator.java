package PracticeProblem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem 2: Library Item Due Date Calculator
 * Demonstrates OOP Polymorphism for calculating borrowing due dates across item types.
 */
abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getBorrowingDurationDays();

    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getBorrowingDurationDays());
    }

    public void displayDueDate(LocalDate currentDate) {
        System.out.println(title + ": " + calculateDueDate(currentDate));
    }
}

class BookItem extends LibraryItem {
    public BookItem(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDurationDays() {
        return 14; // 14 days borrowing duration
    }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDurationDays() {
        return 7; // 7 days borrowing duration
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDurationDays() {
        return 3; // 3 days borrowing duration
    }
}

public class LibraryDueDateCalculator {
    public static void processBorrowedItems(List<LibraryItem> items, LocalDate currentDate) {
        for (LibraryItem item : items) {
            item.displayDueDate(currentDate);
        }
    }

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        List<LibraryItem> items = new ArrayList<>();
        items.add(new BookItem("1984"));
        items.add(new DvdItem("The Matrix"));
        items.add(new MagazineItem("Forbes Issue 500"));

        processBorrowedItems(items, currentDate);
    }
}
