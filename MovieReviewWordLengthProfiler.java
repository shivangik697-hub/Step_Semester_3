public class MovieReviewWordLengthProfiler {

    public static void classifyWordLengths(String review) {
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        String[] words = review.trim().split("\\s+");

        for (String word : words) {
            int length = word.length();

            if (length >= 1 && length <= 4) {
                shortWords++;
            } else if (length <= 8) {
                mediumWords++;
            } else {
                longWords++;
            }
        }

        System.out.println(
                "Short: " + shortWords
                + " | Medium: " + mediumWords
                + " | Long: " + longWords
        );
    }
}
