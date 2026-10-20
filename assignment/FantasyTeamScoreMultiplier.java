package week5assignment;

import java.util.Arrays;

/**
 * PROBLEM 1 • Easy
 * Fantasy Team Score Multiplier
 */
public class FantasyTeamScoreMultiplier {

    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null || captainIndex < 0 || viceCaptainIndex < 0 
                || captainIndex >= playerScores.length || viceCaptainIndex >= playerScores.length) {
            return;
        }
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
    }
}
