// Problem no. 8
public class StudentGradeAssignment {
    public static String getGrade(int marks) {
        if (marks >= 90) {
            return "Grade A";
        } else if (marks >= 75) {
            return "Grade B";
        } else if (marks >= 60) {
            return "Grade C";
        } else if (marks >= 40) {
            return "Grade D";
        } else {
            return "Grade F";
        }
    }

    public static void main(String[] args) {
        int[] sample = {72, 95, 35};
        for (int m : sample) {
            System.out.println(getGrade(m));
        }
    }
}
