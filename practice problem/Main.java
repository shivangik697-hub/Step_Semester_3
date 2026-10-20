public class Main {

    public static void main(String[] args) {
        System.out.println("=========================================================");
        System.out.println("     DAY 1 LIVE-CODING SESSION — 5 PROBLEMS SOLUTIONS     ");
        System.out.println("=========================================================\n");

        // ----------------------------------------------------
        // Problem 1: Rock-Paper-Scissors Game
        // ----------------------------------------------------
        System.out.println("=== 1. Rock-Paper-Scissors Game ===");
        String[] predefinedPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        RockPaperScissorsGame.runSimulation(predefinedPlayerMoves);
        System.out.println();

        // ----------------------------------------------------
        // Problem 2: Palindrome Checker (3 Approaches)
        // ----------------------------------------------------
        System.out.println("=== 2. Palindrome Checker (3 Approaches) ===");
        PalindromeChecker.displayPalindromeResults("madam");
        System.out.println();
        PalindromeChecker.displayPalindromeResults("hello");
        System.out.println();

        // ----------------------------------------------------
        // Problem 3: BMI Calculator for a Team
        // ----------------------------------------------------
        System.out.println("=== 3. BMI Calculator for a Team ===");
        System.out.println("--- Individual Sample Outputs ---");
        BmiCalculator.printPersonBmi(1, 1.75, 70);
        BmiCalculator.printPersonBmi(2, 1.60, 90);
        System.out.println("\n--- Corporate Wellness Team Department Report ---");
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.85, 1.55, 1.78, 1.62, 1.90};
        double[] weights = {70.0, 90.0, 65.0, 85.0, 72.0, 95.0, 48.0, 80.0, 58.0, 110.0};
        BmiCalculator.printWellnessReport(heights, weights);
        System.out.println();

        // ----------------------------------------------------
        // Problem 4: First Non-Repeating Character
        // ----------------------------------------------------
        System.out.println("=== 4. First Non-Repeating Character ===");
        FirstNonRepeatingCharacter.displayFirstNonRepeatingChar("swiss");
        FirstNonRepeatingCharacter.displayFirstNonRepeatingChar("aabbcc");
        System.out.println();

        // ----------------------------------------------------
        // Problem 5: Reverse Customer Name
        // ----------------------------------------------------
        System.out.println("=== 5. Reverse Customer Name ===");
        ReverseCustomerName.displayReversedName("Sunil");
        System.out.println("\n=========================================================");
    }
}
