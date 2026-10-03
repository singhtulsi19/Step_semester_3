import java.util.Scanner;

abstract class Ticket {
    protected int count;
    private static final double CONVENIENCE_FEE = 20;

    Ticket(int count) {
        this.count = count;
    }

    protected abstract double getPrice();

    public double getTotal() {
        return (getPrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    protected double getPrice() {
        return 150;
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    protected double getPrice() {
        return 250;
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    protected double getPrice() {
        return 400;
    }
}

public class MovieTicketCounter {
    public static Ticket createTicket(String seat, int count) {
        if (seat.equals("REGULAR")) {
            return new RegularTicket(count);
        }
        if (seat.equals("PREMIUM")) {
            return new PremiumTicket(count);
        }
        return new ReclinerTicket(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            Ticket ticket = createTicket(seat, count);
            double amount = ticket.getTotal();
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
