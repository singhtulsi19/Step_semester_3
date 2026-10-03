import java.util.Scanner;

abstract class Staff {
    protected String name;

    Staff(String name) {
        this.name = name;
    }

    public abstract double getPay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    public double getPay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    public double getPay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends Staff {
    private double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    public double getPay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static Staff createStaff(String type, String name, double first, double second) {
        if (type.equals("FULLTIME")) {
            return new FullTimeStaff(name, first);
        }
        if (type.equals("HOURLY")) {
            return new HourlyStaff(name, first, second);
        }
        return new InternStaff(name, first);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double first = sc.nextDouble();
            double second = 0;

            if (type.equals("HOURLY")) {
                second = sc.nextDouble();
            }

            Staff staff = createStaff(type, name, first, second);
            double pay = staff.getPay();
            System.out.printf("%s: %.2f%n", name, pay);
            total += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", total);
    }
}
