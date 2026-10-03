import java.util.Scanner;

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    protected abstract double getPower();

    public double getUnits() {
        return getPower() * hours / 1000;
    }

    public double getUnits(boolean saver) {
        double units = getUnits();
        if (saver) {
            units = units * 0.75;
        }
        return units;
    }

    public double getCost(boolean saver) {
        return getUnits(saver) * 8;
    }

    public abstract boolean supportsSaver();
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    protected double getPower() {
        return 150;
    }

    public boolean supportsSaver() {
        return false;
    }
}

class AirConditioner extends Appliance {
    AirConditioner(double hours) {
        super(hours);
    }

    protected double getPower() {
        return 1500;
    }

    public boolean supportsSaver() {
        return true;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    protected double getPower() {
        return 100;
    }

    public boolean supportsSaver() {
        return false;
    }
}

class Washer extends Appliance {
    Washer(double hours) {
        super(hours);
    }

    protected double getPower() {
        return 500;
    }

    public boolean supportsSaver() {
        return true;
    }
}

public class HomeApplianceEnergyReport {
    public static Appliance createAppliance(String type, double hours) {
        if (type.equals("FRIDGE")) {
            return new Fridge(hours);
        }
        if (type.equals("AC")) {
            return new AirConditioner(hours);
        }
        if (type.equals("TV")) {
            return new Television(hours);
        }
        return new Washer(hours);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            Appliance appliance = createAppliance(type, hours);

            if (saver && !appliance.supportsSaver()) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.getUnits(saver);
            double cost = appliance.getCost(saver);
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", type, units, cost);
            total += cost;
        }

        System.out.printf("Total Cost: %.2f%n", total);
    }
}
