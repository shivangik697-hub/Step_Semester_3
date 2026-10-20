import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    /**
     * Finds and returns the first non-repeating character in the given text.
     * Scans the string left to right after computing character frequencies.
     *
     * @param text input string
     * @return the first character with frequency 1, or '\0' if no non-repeating character exists.
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (freqMap.get(c) == 1) {
                return c;
            }
        }

        return '\0';
    }

    /**
     * Displays the result of finding the first non-repeating character.
     *
     * @param text input string
     */
    public static void displayFirstNonRepeatingChar(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.printf("Input: \"%s\" -> Output: No Non-Repeating Character Found\n", text);
        } else {
            System.out.printf("Input: \"%s\" -> Output: First Non-Repeating Character: '%c'\n", text, result);
        }
    }
}
