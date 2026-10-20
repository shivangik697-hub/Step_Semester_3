package PracticeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1: Payment System Fee Calculation
 * Demonstrates OOP Polymorphism for payment processing with distinct fee calculations.
 */
abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract String getPaymentType();
    public abstract double calculateAdjustedAmount();

    public void displayTransaction() {
        System.out.printf("%s: %.2f%n", getPaymentType(), calculateAdjustedAmount());
    }
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.02; // 2% processing fee
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.01; // 1% processing fee
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public String getPaymentType() {
        return "BANKTRANSFER";
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.00; // No processing fee
    }
}

public class PaymentFeeCalculator {
    public static void processPayments(List<Payment> payments) {
        double grandTotal = 0;
        for (Payment payment : payments) {
            payment.displayTransaction();
            grandTotal += payment.calculateAdjustedAmount();
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();
        payments.add(new CardPayment(1000));
        payments.add(new WalletPayment(500));
        payments.add(new BankTransferPayment(2000));

        processPayments(payments);
    }
}
