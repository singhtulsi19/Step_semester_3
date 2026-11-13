// Problem no. 10
class Student {
    private String name;
    private double[] marks;

    public Student(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        if (marks == null || marks.length == 0) return 0.0;
        double sum = 0;
        for (double m : marks) {
            sum += m;
        }
        return sum / marks.length;
    }

    public char calculateGrade(double avg) {
        if (avg >= 75) {
            return 'B';
        } else if (avg >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void printResultCard() {
        double avg = calculateAverage();
        char grade = calculateGrade(avg);
        System.out.printf("%s: Average %.1f, Grade %c%n", name.toUpperCase(), avg, grade);
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Student s1 = new Student("Asha", new double[]{80, 90, 70});
        Student s2 = new Student("Ravi", new double[]{60, 55, 50});

        s1.printResultCard();
        s2.printResultCard();
    }
}
