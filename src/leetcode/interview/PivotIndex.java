package leetcode.interview;

public class PivotIndex {

    public static int pivotIndex(int[] nums) {

        int left = 0, sum = 0, j = 1;

        for (int num : nums)
            sum += num;

        for (int i = 0; i < nums.length - 1; i++) {
            if (left == sum)
                return i;
            else {
                left += nums[i];
                sum -= nums[j++];
            }
        }
        return -1;
    }
}
