package leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        int curr = 1;

        Arrays.fill(ans, 1);

        for (int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        curr = 1;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        
        
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4}; // {24, 12, 8, 6}
        int[] ans = productExceptSelf(nums);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
