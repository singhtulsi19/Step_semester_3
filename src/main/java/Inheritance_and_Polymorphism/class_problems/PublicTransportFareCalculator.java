import java.util.Scanner;

public class PublicTransportFareCalculator {
    static abstract class Transport {
        double distance;

        Transport(double distance) {
            this.distance = distance;
        }

        abstract double calculateFare();
    }

    static class Bus extends Transport {
        Bus(double distance) { super(distance); }
        double calculateFare() { return Math.min(2 + 0.1 * distance, 10); }
    }

    static class Train extends Transport {
        Train(double distance) { super(distance); }
        double calculateFare() { return 3 + 0.15 * distance; }
    }

    static class Metro extends Transport {
        double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        double calculateFare() { return (1.5 + 0.2 * distance) * peakHourFactor; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Transport transport;

            if (type.equals("BUS")) {
                transport = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                transport = new Train(distance);
            } else {
                double factor = sc.nextDouble();
                transport = new Metro(distance, factor);
            }

            double fare = transport.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
