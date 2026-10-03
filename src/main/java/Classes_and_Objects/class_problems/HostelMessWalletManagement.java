public class HostelMessWalletManagement {
    static class MessWallet {
        private double balance;

        MessWallet(double openingBalance) {
            if (openingBalance < 0) {
                System.out.println("Opening balance cannot be negative");
                balance = 0;
            } else {
                balance = openingBalance;
            }
        }

        void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected");
                return;
            }
            balance += amount;
            System.out.println("Balance after top-up: " + balance);
        }

        void deduct(double amount) {
            if (amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
                return;
            }
            balance -= amount;
        }

        double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
