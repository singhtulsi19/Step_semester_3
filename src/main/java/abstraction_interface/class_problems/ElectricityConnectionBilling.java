import java.util.Scanner;

abstract class Connection {
    protected double units;

    Connection(double units) {
        this.units = units;
    }

    public abstract double getBill();
}

class HomeConnection extends Connection {
    HomeConnection(double units) {
        super(units);
    }

    public double getBill() {
        if (units <= 100) {
            return units * 5;
        }
        return 100 * 5 + (units - 100) * 7;
    }
}

class ShopConnection extends Connection {
    ShopConnection(double units) {
        super(units);
    }

    public double getBill() {
        return units * 8 + 100;
    }
}

class FactoryConnection extends Connection {
    FactoryConnection(double units) {
        super(units);
    }

    public double getBill() {
        return Math.max(units * 6, 1000);
    }
}

public class ElectricityConnectionBilling {
    public static Connection createConnection(String type, double units) {
        if (type.equals("HOME")) {
            return new HomeConnection(units);
        }
        if (type.equals("SHOP")) {
            return new ShopConnection(units);
        }
        return new FactoryConnection(units);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            Connection connection = createConnection(type, units);
            double bill = connection.getBill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
