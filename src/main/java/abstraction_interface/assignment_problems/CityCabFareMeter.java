import java.util.Scanner;

abstract class Cab {
    protected double km;

    Cab(double km) {
        this.km = km;
    }

    protected abstract double getRate();

    public double getFare() {
        double fare = km * getRate();
        if (fare < 100) {
            fare = 100;
        }
        return fare;
    }

    public abstract boolean hasNightService();
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    protected double getRate() {
        return 10;
    }

    public boolean hasNightService() {
        return false;
    }
}

class SedanCab extends Cab {
    SedanCab(double km) {
        super(km);
    }

    protected double getRate() {
        return 14;
    }

    public boolean hasNightService() {
        return true;
    }
}

class SUVCab extends Cab {
    SUVCab(double km) {
        super(km);
    }

    protected double getRate() {
        return 18;
    }

    public boolean hasNightService() {
        return true;
    }
}

public class CityCabFareMeter {
    public static Cab createCab(String type, double km) {
        if (type.equals("MINI")) {
            return new MiniCab(km);
        }
        if (type.equals("SEDAN")) {
            return new SedanCab(km);
        }
        return new SUVCab(km);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab = createCab(type, km);

            if (time.equals("NIGHT") && !cab.hasNightService()) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.getFare();
            if (time.equals("NIGHT")) {
                fare = fare * 1.20;
            }
            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
