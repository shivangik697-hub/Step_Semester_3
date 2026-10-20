/**
 * M3. Course Credit Management
 * 
 * Scenario:
 * Some courses come with a separate lab component and lab credit count; most don't.
 * Support both without writing the same setup logic twice.
 */
public class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    // Constructor setting all four fields directly
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Constructor for theory-only courses, chains to four-arg constructor using this(...)
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }

    public void printCourseDetails() {
        System.out.println(code + " total credits: " + totalCredits());
    }

    public static void main(String[] args) {
        Course c1 = new Course("21CSC201J", "Data Structures", 4);
        Course c2 = new Course("21CSC205L", "DSA Lab", 3, 1);

        c1.printCourseDetails();
        c2.printCourseDetails();
    }
}
