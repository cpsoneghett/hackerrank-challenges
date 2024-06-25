package leetcode.interview.medium;

public class RemoveDuplicatesII {

    public static int removeDuplicatesII(int[] nums) {

        int i = 0;

        for(int num : nums) {
            if(i < 2 || nums[i-2] != num) {
                nums[i] = num;
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3, 3, 4, 5, 5};
        // 1 1 2 3 3 4 5 0
        //
        //int[] nums2 = {3, 2, 2, 3};

        System.out.println(removeDuplicatesII(nums));
        //System.out.println(removeDuplicates(nums2, 3));
    }
}
