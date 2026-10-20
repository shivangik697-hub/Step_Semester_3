import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Week 5 Category C Practice Problems Solution Runner
 */
public class PracticeProblems {

    // PROBLEM 1: Fantasy Team Score Multiplier
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null || captainIndex < 0 || viceCaptainIndex < 0 
                || captainIndex >= playerScores.length || viceCaptainIndex >= playerScores.length) {
            return;
        }
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    // PROBLEM 2: Duplicate Player Pick Checker
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null) return "No Duplicates Found";

        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i] != null && playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    // PROBLEM 3: Top Performer Tracker
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length == 0) return "";
        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) min = scores[i];
            if (scores[i] > max) max = scores[i];
        }

        return "Min: " + min + " | Max: " + max + " | Spread: " + (max - min);
    }

    // PROBLEM 4: Match Day Grid Analyzer
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) return 0.0;
        double sum = 0;
        for (int runs : row) sum += runs;
        return sum / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) return "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String classification = (avg >= threshold) ? "Power Surge" : "Normal";
            if (i > 0) sb.append(" | ");
            sb.append("Match ").append(i).append(": ").append(classification);
        }

        return sb.toString();
    }

    // PROBLEM 5: Fantasy League Auto-Draft Ranking Engine
    public static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() { return name; }
        public int getMatchesPlayed() { return matchesPlayed; }
        public double getBattingAverage() { return battingAverage; }
        public boolean isInjured() { return injured; }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) return "";

        List<Player> draftableList = new ArrayList<>();
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftableList.add(p);
            }
        }

        Player[] draftableArray = draftableList.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append(i + 1).append(". ").append(draftableArray[i].getName());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== STEP SEM 3 - WEEK 5 PRACTICE PROBLEMS ===");

        System.out.println("\n--- Problem 1: Fantasy Team Score Multiplier ---");
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println("Output: " + Arrays.toString(scores));

        System.out.println("\n--- Problem 2: Duplicate Player Pick Checker ---");
        System.out.println("Output 1: " + findDuplicatePick(new String[]{"Kohli", "Bumrah", "Kohli", "Rohit"}));
        System.out.println("Output 2: " + findDuplicatePick(new String[]{"Kohli", "Bumrah", "Rohit"}));

        System.out.println("\n--- Problem 3: Top Performer Tracker ---");
        System.out.println("Output: " + findMinMaxSpread(new int[]{45, 82, 79, 90, 33, 90, 61}));

        System.out.println("\n--- Problem 4: Match Day Grid Analyzer ---");
        int[][] runsPerOver = {{4, 6, 8}, {10, 12, 14}, {2, 3, 1}};
        System.out.println("Output: " + classifyMatches(runsPerOver, 8));

        System.out.println("\n--- Problem 5: Fantasy League Auto-Draft Ranking Engine ---");
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println("Output: " + draftAndRank(players));
    }
}
