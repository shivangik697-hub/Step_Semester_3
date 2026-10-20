/**
 * M5. Student and College Information Management
 * 
 * Scenario:
 * A club member's first draft of Student stores attendance, name, AND the college name
 * as instance fields — meaning every single student object ends up with its own copy of
 * "SRM Institute of Science and Technology" typed in separately. Fix the design.
 */
public class Student {
    String name;
    double attendance;

    // Shared static field for college name
    static String collegeName = "SRM Institute of Science and Technology";

    // Shared static field for tracking student count
    static int studentCount = 0;

    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    // Static method that accesses only static fields
    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ravi", 85.0);
        Student s2 = new Student("Anitha", 92.5);

        // Called through class name, not through instance
        Student.printCollegeInfo();
    }
}
