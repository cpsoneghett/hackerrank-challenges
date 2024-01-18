package leetcode.interview;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        int i = 0, j = 0;

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
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] nums2 = {3, 2, 2, 3};

        System.out.println(removeElement(nums, 2));
        System.out.println(removeElement(nums2, 3));
    }
}
