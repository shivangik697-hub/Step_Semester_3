import java.util.*;

public class Week2PracticeProblems {

    // =========================================================================
    // Problem 1: Vowel & Consonant Counter
    // =========================================================================
    /**
     * Counts vowels and consonants in a string (ignoring spaces).
     *
     * @param text input string
     */
    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = Character.toLowerCase(text.charAt(i));
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    // =========================================================================
    // Problem 2: CSV Student Record Parser
    // =========================================================================
    /**
     * Parses a CSV line in the form "Name,RollNumber,Department".
     * Validates that exactly 3 fields are present.
     *
     * @param csvLine CSV formatted input line
     */
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Name: " + fields[0].trim() +
                               " | Roll No: " + fields[1].trim() +
                               " | Dept: " + fields[2].trim());
        }
    }

    // =========================================================================
    // Problem 3: File Extension Validator
    // =========================================================================
    /**
     * Validates if the file extension is one of: pdf, docx, zip (case-insensitive).
     *
     * @param filename name of the file
     * @return "Accepted" or "Rejected — invalid file type"
     */
    public static String validateFileExtension(String filename) {
        if (filename == null) {
            return "Rejected — invalid file type";
        }

        int lastDot = filename.lastIndexOf('.');
        if (lastDot == -1 || lastDot == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String ext = filename.substring(lastDot + 1);

        if (ext.equalsIgnoreCase("pdf") ||
            ext.equalsIgnoreCase("docx") ||
            ext.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    // =========================================================================
    // Problem 4: Masked Phone Number Formatter
    // =========================================================================
    /**
     * Validates that phone number is 10 digits and masks it as "XXXXXX-1234".
     *
     * @param phone input phone number string
     * @return masked phone string or "Invalid phone number"
     */
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder sb = new StringBuilder("XXXXXX");
        sb.append("-");
        sb.append(phone.substring(6));

        return sb.toString();
    }

    // =========================================================================
    // Problem 5: Bank Transaction Reference Generator & Validator
    // =========================================================================
    /**
     * Normalizes a raw reference code by trimming whitespace and converting
     * the first 3 characters (bank code) to uppercase.
     *
     * @param raw raw input reference
     * @return normalized reference code
     */
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }

        String code = raw.trim();

        if (code.length() >= 3) {
            String bankCode = code.substring(0, 3).toUpperCase();
            return bankCode + code.substring(3);
        }

        return code.toUpperCase();
    }

    /**
     * Validates reference code (14 chars: 3 letters + 11 digits) and formats it:
     * "[BANKCODE] DATE: dd/MM/yy | SEQ: 12345"
     *
     * @param reference normalized reference code
     * @return formatted reference string or error message
     */
    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(day).append("/").append(month).append("/").append(year)
          .append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    // =========================================================================
    // Main Method — Demonstration
    // =========================================================================
    public static void main(String[] args) {
        System.out.println("=========================================================");
        System.out.println("      DAY 2 LIVE-CODING SESSION — PRACTICE PROBLEMS      ");
        System.out.println("=========================================================\n");

        // ----------------------------------------------------
        // Problem 1: Vowel & Consonant Counter
        // ----------------------------------------------------
        System.out.println("=== 1. Vowel & Consonant Counter ===");
        System.out.print("Input: \"Java Programming\" -> ");
        countVowelsAndConsonants("Java Programming");
        System.out.println();

        // ----------------------------------------------------
        // Problem 2: CSV Student Record Parser
        // ----------------------------------------------------
        System.out.println("=== 2. CSV Student Record Parser ===");
        System.out.println("Input: \"Ananya Verma,RA2211003010123,CSE\"");
        System.out.print("Output: ");
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        System.out.println("\nInput: \"Ananya Verma,CSE\"");
        System.out.print("Output: ");
        parseStudentRecord("Ananya Verma,CSE");
        System.out.println();

        // ----------------------------------------------------
        // Problem 3: File Extension Validator
        // ----------------------------------------------------
        System.out.println("=== 3. File Extension Validator ===");
        System.out.println("Input: \"Assignment.PDF\" -> Output: " + validateFileExtension("Assignment.PDF"));
        System.out.println("Input: \"notes.txt\" -> Output: " + validateFileExtension("notes.txt"));
        System.out.println();

        // ----------------------------------------------------
        // Problem 4: Masked Phone Number Formatter
        // ----------------------------------------------------
        System.out.println("=== 4. Masked Phone Number Formatter ===");
        System.out.println("Input: \"9876543210\" -> Output: " + maskPhoneNumber("9876543210"));
        System.out.println("Input: \"98765\" -> Output: " + maskPhoneNumber("98765"));
        System.out.println();

        // ----------------------------------------------------
        // Problem 5: Bank Transaction Reference Generator & Validator
        // ----------------------------------------------------
        System.out.println("=== 5. Bank Transaction Reference Generator & Validator ===");
        String raw1 = " hdf03022600042 ";
        String norm1 = normalizeReference(raw1);
        System.out.println("Input: \"" + raw1 + "\"");
        System.out.println("Output: " + validateAndFormat(norm1));

        System.out.println();
        String raw2 = "12F03022600042";
        String norm2 = normalizeReference(raw2);
        System.out.println("Input: \"" + raw2 + "\"");
        System.out.println("Output: " + validateAndFormat(norm2));

        System.out.println("\n=========================================================");
    }
}
