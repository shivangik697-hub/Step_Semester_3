public class BmiCalculator {

    /**
     * Classifies health status based on BMI score.
     * BMI < 18.5 -> Underweight
     * 18.5 - 24.9 -> Normal
     * 25 - 29.9 -> Overweight
     * >= 30 -> Obese
     *
     * @param bmi the body mass index
     * @return status string
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Calculates BMI and displays a tabular wellness report for a department team.
     *
     * @param heights array of employee heights in meters
     * @param weights array of employee weights in kg
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Error: Invalid or mismatched height and weight data.");
            return;
        }

        System.out.println("==========================================================================");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s\n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-12s\n",
                    (i + 1), h, w, bmi, status);
        }
        System.out.println("==========================================================================");
    }

    /**
     * Helper to print sample single-person output format matching PDF.
     */
    public static void printPersonBmi(int personNum, double height, double weight) {
        double bmi = weight / (height * height);
        String status = getBmiStatus(bmi);
        System.out.printf("Person %d — Height: %.2f m, Weight: %.1f kg -> BMI: %.2f | Status: %s\n",
                personNum, height, weight, bmi, status);
    }
}
