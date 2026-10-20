import java.util.Random;

public class RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static final Random random = new Random();

    /**
     * Determines the winner of a single round of Rock-Paper-Scissors.
     *
     * @param playerMove   the player's move
     * @param computerMove the computer's move
     * @return "Player Wins", "Computer Wins", or "Draw"
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            return "Invalid Move";
        }
        String p = playerMove.trim();
        String c = computerMove.trim();

        if (p.equalsIgnoreCase(c)) {
            return "Draw";
        }

        if ((p.equalsIgnoreCase("Rock") && c.equalsIgnoreCase("Scissors")) ||
            (p.equalsIgnoreCase("Paper") && c.equalsIgnoreCase("Rock")) ||
            (p.equalsIgnoreCase("Scissors") && c.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    /**
     * Generates a random move for the computer.
     *
     * @return "Rock", "Paper", or "Scissors"
     */
    public static String getRandomComputerMove() {
        return MOVES[random.nextInt(MOVES.length)];
    }

    /**
     * Runs a simulation for N rounds using predefined player moves (or randomly selected if not provided).
     * Prints round outcomes, a summary table, and statistics (Wins, Losses, Draws, Win %).
     *
     * @param playerMoves list of player moves for each round
     */
    public static void runSimulation(String[] playerMoves) {
        int rounds = playerMoves.length;
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < rounds; i++) {
            computerMoves[i] = getRandomComputerMove();
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        // Print Round-by-Round Log
        for (int i = 0; i < rounds; i++) {
            System.out.printf("Round %d — Player: %s, Computer: %s -> %s\n",
                    (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }

        // Summary Table
        System.out.println("\nFinal Summary (after " + rounds + " rounds)");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-7s | %-12s | %-13s | %-12s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("Round %-2d | %-12s | %-13s | %-12s\n",
                    (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("---------------------------------------------------------");

        double winPercentage = ((double) wins / rounds) * 100.0;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n",
                wins, losses, draws, winPercentage);
    }
}
