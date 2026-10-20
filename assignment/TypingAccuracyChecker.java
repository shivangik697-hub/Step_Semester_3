public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int totalCharacters = Math.min(original.length(), typed.length());
        int matchedCharacters = 0;
        int firstMismatch = -1;

        for (int i = 0; i < totalCharacters; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        // The assignment specifies equal-length strings.
        // This guard also handles accidental unequal-length input safely.
        if (original.length() != typed.length()) {
            if (firstMismatch == -1) {
                firstMismatch = totalCharacters;
            }
        }

        double accuracy = original.length() == 0
                ? 100.0
                : (matchedCharacters * 100.0) / original.length();

        System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%% | ",
                matchedCharacters, original.length(), accuracy
        );

        if (firstMismatch == -1) {
            System.out.println("No Mismatches");
        } else if (firstMismatch < original.length() && firstMismatch < typed.length()) {
            System.out.println(
                    "First Mismatch at position " + (firstMismatch + 1)
                    + " ('" + original.charAt(firstMismatch)
                    + "' vs '" + typed.charAt(firstMismatch) + "')"
            );
        } else {
            System.out.println(
                    "First Mismatch at position " + (firstMismatch + 1)
            );
        }
    }
}
