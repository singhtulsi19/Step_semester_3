// Problem no. 5
import java.util.Arrays;

public class DiceThrowTally {
    public static int[] diceSort(int[] rolls) {
        int[] counts = new int[7];

        for (int r : rolls) {
            if (r >= 1 && r <= 6) {
                counts[r]++;
            }
        }

        StringBuilder countStr = new StringBuilder("Counts: ");
        for (int v = 1; v <= 6; v++) {
            countStr.append(v).append(":").append(counts[v]);
            if (v < 6) {
                countStr.append("  ");
            }
        }
        System.out.println(countStr.toString());

        int[] sorted = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            for (int i = 0; i < counts[v]; i++) {
                sorted[idx++] = v;
            }
        }

        System.out.println("Sorted: " + Arrays.toString(sorted));
        return sorted;
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};
        diceSort(rolls);
    }
}
