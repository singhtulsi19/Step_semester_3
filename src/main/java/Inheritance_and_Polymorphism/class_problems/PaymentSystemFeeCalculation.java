import java.util.Scanner;

public class PaymentSystemFeeCalculation {
    static abstract class Payment {
        double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract double getFinalAmount();
    }

    static class CardPayment extends Payment {
        CardPayment(double amount) { super(amount); }
        double getFinalAmount() { return amount * 1.02; }
    }

    static class WalletPayment extends Payment {
        WalletPayment(double amount) { super(amount); }
        double getFinalAmount() { return amount * 1.01; }
    }

    static class BankTransferPayment extends Payment {
        BankTransferPayment(double amount) { super(amount); }
        double getFinalAmount() { return amount; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment payment;

            if (type.equals("CARD")) {
                payment = new CardPayment(amount);
            } else if (type.equals("WALLET")) {
                payment = new WalletPayment(amount);
            } else {
                payment = new BankTransferPayment(amount);
            }

            double finalAmount = payment.getFinalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", type, finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
