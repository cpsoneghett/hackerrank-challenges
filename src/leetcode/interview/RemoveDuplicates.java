package leetcode.interview;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        int i = 0, j = 1;
        int val = nums[0];

        while (j < nums.length) {

            if(nums[j]!=val) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }

        int k = i-1;
        int counter = 0;
        for (int l = 0; l <= k; l++) {
            counter++;
        }

        return counter;
    }

    private static void swap(int[] nums, int a, int b) {
        int aux = nums[a];
        nums[a] = nums[b];
        nums[b] = aux;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        //int[] nums2 = {3, 2, 2, 3};

        System.out.println(removeDuplicates(nums));
        //System.out.println(removeDuplicates(nums2, 3));
    }
}
