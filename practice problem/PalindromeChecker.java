import java.util.Arrays;

public class PalindromeChecker {

    /**
     * Iterative approach: compares characters from both ends moving toward the middle.
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        String clean = text.toLowerCase();
        int left = 0;
        int right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Recursive approach: recursively compares the first and last characters,
     * shrinking the substring with each call.
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        return isRecursiveHelper(text.toLowerCase());
    }

    private static boolean isRecursiveHelper(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isRecursiveHelper(text.substring(1, text.length() - 1));
    }

    /**
     * Array reversal approach: converts string to character array, reverses it,
     * and compares it to the original.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        String clean = text.toLowerCase();
        char[] original = clean.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return Arrays.equals(original, reversed);
    }

    /**
     * Runs all three palindrome detection approaches on the input text and prints the results.
     */
    public static void displayPalindromeResults(String text) {
        boolean iter = isPalindromeIterative(text);
        boolean recur = isPalindromeRecursive(text);
        boolean rev = isPalindromeArrayReversal(text);

        String iterStr = iter ? "Palindrome" : "Not Palindrome";
        String recurStr = recur ? "Palindrome" : "Not Palindrome";
        String revStr = rev ? "Palindrome" : "Not Palindrome";

        System.out.printf("Input: \"%s\"\nOutput: Iterative: %s | Recursive: %s | Array Reversal: %s\n",
                text, iterStr, recurStr, revStr);
    }
}
