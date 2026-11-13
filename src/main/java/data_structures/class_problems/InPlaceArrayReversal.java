// Problem no. 4
import java.util.Arrays;

public class InPlaceArrayReversal {
    public static void reverseInPlace(int[] tokens) {
        int left = 0;
        int right = tokens.length - 1;
        while (left < right) {
            int temp = tokens[left];
            tokens[left] = tokens[right];
            tokens[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] tokens = {11, 22, 33, 44};
        reverseInPlace(tokens);
        System.out.println(Arrays.toString(tokens));
    }
}
