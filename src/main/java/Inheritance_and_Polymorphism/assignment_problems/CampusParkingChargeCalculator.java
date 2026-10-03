import java.util.Scanner;

public class CampusParkingChargeCalculator {
    static abstract class Vehicle {
        int hours;
        Vehicle(int hours) { this.hours = hours; }
        abstract double charge();
    }

    static class Bike extends Vehicle {
        Bike(int hours) { super(hours); }
        double charge() { return hours * 10; }
    }

    static class Car extends Vehicle {
        Car(int hours) { super(hours); }
        double charge() { return 30 + (hours - 1) * 20; }
    }

    static class Truck extends Vehicle {
        Truck(int hours) { super(hours); }
        double charge() { return Math.max(hours * 50, 100); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle vehicle;

            if (type.equals("BIKE")) {
                vehicle = new Bike(hours);
            } else if (type.equals("CAR")) {
                vehicle = new Car(hours);
            } else {
                vehicle = new Truck(hours);
            }

            double charge = vehicle.charge();
            total += charge;
            System.out.printf("%s: %.2f%n", type, charge);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
