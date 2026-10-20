/**
 * Main Runner for Category C Problems
 */
public class PracticeProblems {

    public static void main(String[] args) {
        System.out.println("=== M1. Student Placement Record Management ===");
        PlacementRecord[] records = {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };
        for (PlacementRecord record : records) {
            record.printRecord();
        }

        System.out.println("\n=== M2. Hostel Mess Wallet Management ===");
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());

        System.out.println("\n=== M3. Course Credit Management ===");
        Course c1 = new Course("21CSC201J", "Data Structures", 4);
        Course c2 = new Course("21CSC205L", "DSA Lab", 3, 1);
        System.out.println(c1.code + " total credits: " + c1.totalCredits());
        System.out.println(c2.code + " total credits: " + c2.totalCredits());

        System.out.println("\n=== M4. Library ID Card Management ===");
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi;
        duplicate.booksIssued = 3;
        IdCard separate = new IdCard("Ravi", 3);

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));

        System.out.println("\n=== M5. Student and College Information Management ===");
        new Student("Ravi", 85.0);
        new Student("Anitha", 92.5);
        Student.printCollegeInfo();
    }
}
