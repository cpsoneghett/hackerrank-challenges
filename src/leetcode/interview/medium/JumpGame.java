package leetcode.interview.medium;

public class JumpGame {

    public static boolean canJump2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > j)
                return false;
            j = Math.max(j, i + nums[i]);
        }
        return true;
    }

    public static boolean canJump(int[] nums) {

        int start = nums[0];
        int size = nums.length;
        int i = 0;

        if(start > size)
            return false;

        boolean reachedEnd = true;

        while (!reachedEnd) {
            int n = nums[i + start];

            if((i+start) > nums.length) {

            }

        }

        return reachedEnd;
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, 1, 0, 4};
        int nums2[] = {2, 3, 1, 1, 4};
        int nums3[] = {1};

        System.out.println(canJump2(nums));
    }
}
