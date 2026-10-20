package PracticeProblem;

/**
 * Main Class to execute all Practice Problems from Session 8 (Polymorphism & Inheritance).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Problem 1: Payment System Fee Calculation ===");
        PaymentFeeCalculator.main(args);

        System.out.println("\n=== Problem 2: Library Item Due Date Calculator ===");
        LibraryDueDateCalculator.main(args);

        System.out.println("\n=== Problem 3: Delivery Fee Calculator ===");
        DeliveryFeeCalculator.main(args);

        System.out.println("\n=== Problem 4: Examination Question Grader ===");
        ExamQuestionGrader.main(args);

        System.out.println("\n=== Problem 5: Public Transport Fare Calculator ===");
        TransportFareCalculator.main(args);
    }
}
