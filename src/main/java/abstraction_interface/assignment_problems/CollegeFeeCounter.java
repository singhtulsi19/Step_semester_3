import java.util.Scanner;

abstract class Student {
    protected String name;
    protected double tuition;

    Student(String name, double tuition) {
        this.name = name;
        this.tuition = tuition;
    }

    public abstract double getFee();

    protected double getTransportFee() {
        return 0;
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name, 40000);
    }

    public double getFee() {
        return tuition + getTransportFee();
    }

    protected double getTransportFee() {
        return 12000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name, 40000);
    }

    public double getFee() {
        return tuition + 60000;
    }
}

class ScholarshipStudent extends Student {
    ScholarshipStudent(String name) {
        super(name, 20000);
    }

    public double getFee() {
        return tuition + getTransportFee();
    }

    protected double getTransportFee() {
        return 12000;
    }
}

public class CollegeFeeCounter {
    public static Student createStudent(String type, String name) {
        if (type.equals("DAY_SCHOLAR")) {
            return new DayScholar(name);
        }
        if (type.equals("HOSTELLER")) {
            return new Hosteller(name);
        }
        return new ScholarshipStudent(name);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student = createStudent(type, name);
            double fee = student.getFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}
