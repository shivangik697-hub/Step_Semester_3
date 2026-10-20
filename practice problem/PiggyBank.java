package PracticeProblem;

/**
 * Problem 1: The Piggy Bank
 * Scenario: A savings app tracks how much money a kid has put away.
 */
public class PiggyBank {
    private final String id;
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public String getId() {
        return id;
    }

    public int getSavings() {
        return savings;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public boolean withdraw(int amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("Created PiggyBank: " + pb.getId());
        
        pb.deposit(100);
        System.out.println("pb.deposit(100) -> savings = " + pb.getSavings());
        
        boolean withdraw1 = pb.withdraw(30);
        System.out.println("pb.withdraw(30) -> " + (withdraw1 ? "success" : "rejected") + ", savings = " + pb.getSavings());
        
        boolean withdraw2 = pb.withdraw(500);
        System.out.println("pb.withdraw(500) -> " + (withdraw2 ? "success" : "rejected, savings stays " + pb.getSavings()));
    }
}
