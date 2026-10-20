package PracticeProblem;

/**
 * Problem 5: The Attendance Sheet
 * Scenario: A teacher marks which students are present in class today.
 */
public class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    public boolean markPresent(String studentName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            return false;
        }
        if (isPresent(studentName)) {
            return false; // Avoid duplicate count
        }
        if (presentCount < presentStudents.length) {
            presentStudents[presentCount] = studentName;
            presentCount++;
            return true;
        }
        return false;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String studentName) {
        if (studentName == null) {
            return false;
        }
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equalsIgnoreCase(studentName)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}
