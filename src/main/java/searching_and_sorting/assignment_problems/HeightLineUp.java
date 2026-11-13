// Problem no. 1
import java.util.Arrays;

public class HeightLineUp {
    public static void lineUp(int[] heights) {
        int n = heights.length;
        int pass = 1;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] h1 = {4, 2, 5, 1};
        lineUp(h1);

        System.out.println();

        int[] h2 = {1, 3, 2, 4};
        lineUp(h2);
    }
}
