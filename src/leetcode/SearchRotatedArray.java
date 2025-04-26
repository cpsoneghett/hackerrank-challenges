package leetcode;

public class SearchRotatedArray {

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]) {
                // Left half is sorted
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;

            } else {
                // Right half is sorted
                if (target > nums[mid] && target <= nums[start])
                    start = mid + 1;
                else
                    end = mid - 1;
            }

        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        int v[] = {5, 1, 3};

        System.out.println(search(v, 5));
    }
}
