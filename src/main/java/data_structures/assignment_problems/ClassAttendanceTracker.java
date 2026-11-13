// Problem no. 6
public class ClassAttendanceTracker {
    public static void attendanceSummary(int[] days) {
        int presentCount = 0;
        int longestStreak = 0;
        int currentStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        System.out.println("Present: " + presentCount + ", Longest streak: " + longestStreak);
    }

    public static void main(String[] args) {
        int[] sample1 = {1, 1, 0, 1, 1, 1, 0, 1};
        attendanceSummary(sample1); // Expected: Present: 6, Longest streak: 3

        int[] sample2 = {0, 0, 0};
        attendanceSummary(sample2); // Expected: Present: 0, Longest streak: 0
    }
}
