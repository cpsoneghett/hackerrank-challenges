package leetcode.interview;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i])
                nums[++j] = nums[i];
        }
        return j + 1;
    }

    private static void swap(int[] nums, int a, int b) {
        int aux = nums[a];
        nums[a] = nums[b];
        nums[b] = aux;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 5, 5};
        // 1 1 2 3 3 4 5 0
        //
        //int[] nums2 = {3, 2, 2, 3};

        System.out.println(removeDuplicates(nums));
        //System.out.println(removeDuplicates(nums2, 3));
    }
}
