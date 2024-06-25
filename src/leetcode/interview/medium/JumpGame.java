package leetcode.interview.medium;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > j)
                return false;
            j = Math.max(j, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, 1, 0, 4};
        int nums2[] = {2, 3, 1, 1, 4};
        int nums3[] = {1};

        System.out.println(canJump(nums2));
    }
}
