// Problem no. 5
import java.util.Scanner;

public class DigitSumAndNumberReversal {
    public static void processNumber(int n) {
        int sum = 0;
        int reversed = 0;
        int temp = Math.abs(n);
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            processNumber(sc.nextInt());
        } else {
            processNumber(4721);
        }
        sc.close();
    }
}
