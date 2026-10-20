import java.util.*;

public class Week2Assignment {

    // Problem 1: ATM PIN Length Validator
    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    // Problem 2: Word Reversal Encoder
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder(words[i]);
            result.append(reversedWord.reverse());

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    // Problem 3: Product Inventory CSV Parser
    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println(
                    "Product: " + fields[0] +
                    " | SKU: " + fields[1] +
                    " | Qty: " + fields[2]
            );
        }
    }

    // Problem 4: Library ISBN Normalizer & Validator
    public static String normalizeCode(String raw) {
        String code = raw.trim();

        if (code.length() >= 3) {
            String publisher = code.substring(0, 3).toUpperCase();
            return publisher + code.substring(3);
        }

        return code.toUpperCase();
    }

    public static String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("[")
              .append(code.substring(0, 3))
              .append("] YEAR: ")
              .append(code.substring(3, 7))
              .append(" | CATALOG: ")
              .append(code.substring(7));

        return result.toString();
    }

    // Problem 5: Stop-Word-Filtered Word Frequency Report
    public static void printFilteredWordFrequency(String feedback) {

        String cleanedText = feedback
                .toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = cleanedText.split("\\s+");

        Set<String> stopWords = new HashSet<>(
                Arrays.asList("the", "was", "and", "a", "is", "of", "in")
        );

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (!stopWords.contains(word)) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        // Problem 1
        System.out.println("Problem 1:");
        checkPinLength("482");
        checkPinLength("4820");

        // Problem 2
        System.out.println("\nProblem 2:");
        System.out.println(reverseEachWord("hello club"));

        // Problem 3
        System.out.println("\nProblem 3:");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");

        // Problem 4
        System.out.println("\nProblem 4:");
        String code = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(code));

        System.out.println(validateAndFormat(
                normalizeCode("12N2026004251")
        ));

        // Problem 5
        System.out.println("\nProblem 5:");
        printFilteredWordFrequency(
                "The mentor was great, the session was great and clear."
        );
    }
}
