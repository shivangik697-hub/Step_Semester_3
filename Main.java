public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. Exam Hall Seat Duplication Checker ===");
        SeatDuplicationChecker.checkDuplicateSeats(
                new int[]{101, 102, 103, 102, 105}
        );
        SeatDuplicationChecker.checkDuplicateSeats(
                new int[]{101, 102, 103, 104, 105}
        );

        System.out.println("\n=== 2. Typing Speed Test Accuracy Checker ===");
        TypingAccuracyChecker.checkTypingAccuracy("hello world", "hello worlt");
        TypingAccuracyChecker.checkTypingAccuracy("coding", "coding");

        System.out.println("\n=== 3. Traffic Signal Streak Analyzer ===");
        TrafficSignalStreakAnalyzer.findLongestStreak("RRGGGYRR");
        TrafficSignalStreakAnalyzer.findLongestStreak("RRRRYYGG");

        System.out.println("\n=== 4. Warehouse Inventory Balancer ===");
        WarehouseInventoryBalancer.analyzeInventory(
                new int[]{20, 15, 30},
                new int[]{25, 10, 30}
        );

        System.out.println("\n=== 5. Movie Review Word Length Profiler ===");
        MovieReviewWordLengthProfiler.classifyWordLengths(
                "This movie was absolutely fantastic and thrilling"
        );
    }
}
