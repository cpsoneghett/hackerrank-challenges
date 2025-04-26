public class MaxNumbers {

    public static int maxOperations(int[] nums, int k) {
        int ops = 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == k) {
                ops++;
                left++;
                right--;
            } else if (sum > k) {
                right--;
            } else
                left++;
        }

        return ops;
    }

    public static int maxOperations2(int[] nums, int k) {
        int ops = 0;
        int arr[] = new int[nums.length + 1];

        for (int num : nums)
            arr[num]++;

        for (int num : nums) {

            while (arr[num] > 0) {
                int diff = Math.abs(k - num);

                if (arr[diff] == 0)
                    break;

                if (diff == num && arr[num] >= 2) {
                    arr[num] -= 2;
                    ops++;
                } else if (diff == num && arr[num] < 2) {
                    break;
                } else if (arr[num] + arr[diff] >= 2) {
                    arr[num]--;
                    arr[diff]--;
                    ops++;
                } else
                    break;
            }
        }


        return ops;
    }

    public static void main(String[] args) {
        int[] v = {4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4};
        int[] v2 = {3, 1, 3, 4, 3};
        int[] v3 = {1, 2, 3, 4};

        System.out.println(maxOperations(v, 2));
        System.out.println(maxOperations2(v2, 6));
        System.out.println(maxOperations2(v3, 5));
    }
}
