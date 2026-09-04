import java.util.*;

public class ProductExceptSelf {

    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int left = 1;

        // Product of elements on left
        for (int i = 0; i < n; i++) {
            ans[i] = left;
            left *= nums[i];
        }

        int right = 1;

        // Product of elements on right
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        System.out.println("Output: " + Arrays.toString(result));
    }
}