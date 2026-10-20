package AssignmentProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 3: College Fee Counter
 * Demonstrates Interface (BusUser) for student transport fees.
 */
interface BusUser {
    double getTransportFee();
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTuitionAndOtherFees();

    public double calculateTotalFee() {
        double fee = calculateTuitionAndOtherFees();
        if (this instanceof BusUser) {
            fee += ((BusUser) this).getTransportFee();
        }
        return fee;
    }

    public void displayStudentFee() {
        System.out.printf("%s: %.2f%n", name, calculateTotalFee());
    }
}

class DayScholarStudent extends Student implements BusUser {
    public DayScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionAndOtherFees() {
        return 40000.00;
    }

    @Override
    public double getTransportFee() {
        return 12000.00;
    }
}

class HostellerStudent extends Student {
    public HostellerStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionAndOtherFees() {
        return 40000.00 + 60000.00; // Tuition + Hostel Fee
    }
}

class ScholarStudent extends Student implements BusUser {
    public ScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionAndOtherFees() {
        return 20000.00; // Half tuition
    }

    @Override
    public double getTransportFee() {
        return 12000.00;
    }
}

public class CollegeFeeCounter {
    public static void processStudents(List<Student> students) {
        double totalCollected = 0;
        for (Student s : students) {
            s.displayStudentFee();
            totalCollected += s.calculateTotalFee();
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new DayScholarStudent("Asha"));
        students.add(new HostellerStudent("Ravi"));
        students.add(new ScholarStudent("Neha"));

        processStudents(students);
    }
}
