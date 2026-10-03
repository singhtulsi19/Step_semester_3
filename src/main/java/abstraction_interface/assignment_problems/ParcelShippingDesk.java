import java.util.Scanner;

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double getCharge();

    public double getInsurance() {
        return 0;
    }

    public double getTotal() {
        return getCharge() + getInsurance();
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    public double getCharge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel {
    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    public double getCharge() {
        return 80 + 15 * weight;
    }

    public double getInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel {
    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    public double getCharge() {
        return 40 + 10 * weight + 50;
    }

    public double getInsurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {
    public static Parcel createParcel(String type, double weight, double value) {
        if (type.equals("STANDARD")) {
            return new StandardParcel(weight, value);
        }
        if (type.equals("EXPRESS")) {
            return new ExpressParcel(weight, value);
        }
        return new FragileParcel(weight, value);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel parcel = createParcel(type, weight, value);
            double charge = parcel.getCharge();
            double insurance = parcel.getInsurance();
            double total = parcel.getTotal();
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", type, charge, insurance, total);
            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
