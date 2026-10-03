import java.util.Scanner;

abstract class TravelBooking {
    protected double distance;
    private static final double BOOKING_FEE = 50;

    TravelBooking(double distance) {
        this.distance = distance;
    }

    protected abstract double getBaseFare();

    public double getTotal() {
        return getBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    BusBooking(double distance) {
        super(distance);
    }

    protected double getBaseFare() {
        return distance * 2;
    }
}

class TrainBooking extends TravelBooking {
    TrainBooking(double distance) {
        super(distance);
    }

    protected double getBaseFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    FlightBooking(double distance) {
        super(distance);
    }

    protected double getBaseFare() {
        return 2500 + distance * 4;
    }
}

public class TravelBookingWithCommonFee {
    public static TravelBooking createBooking(String mode, double distance) {
        if (mode.equals("BUS")) {
            return new BusBooking(distance);
        }
        if (mode.equals("TRAIN")) {
            return new TrainBooking(distance);
        }
        return new FlightBooking(distance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            TravelBooking booking = createBooking(mode, distance);
            System.out.printf("%s: %.2f%n", mode, booking.getTotal());
        }
    }
}
