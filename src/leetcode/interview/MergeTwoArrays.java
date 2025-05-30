package leetcode.interview;

public class MergeTwoArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;
        int mergePos = n + m - 1;

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2])
                nums1[mergePos--] = nums1[p1--];
            else
                nums1[mergePos--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {1,1,1};

        merge(nums1, 3, nums2, 3);

        for (int n : nums1)
            System.out.print(n);

        System.out.println();

    }
}
