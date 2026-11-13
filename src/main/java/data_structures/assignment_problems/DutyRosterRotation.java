// Problem no. 8
import java.util.Arrays;

public class DutyRosterRotation {
    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        if (n == 0) return names;
        k = k % n;
        if (k < 0) k += n;
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        String[] names1 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names1, 2))); // Expected: [D, E, A, B, C]

        String[] names2 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names2, 7))); // Expected: [D, E, A, B, C]
    }
}
