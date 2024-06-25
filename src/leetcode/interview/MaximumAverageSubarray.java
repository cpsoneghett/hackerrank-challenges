package leetcode.interview;

public class MaximumAverageSubarray {

    public static double findMaxAverage(int[] nums, int k) {

        double sum = 0.0;
        int n = nums.length;

        if (n == 1 && k != 0)
            return nums[0] / k;

        for (int i = 0; i < k; i++)
            sum += nums[i];

        double aux = sum;

        for (int i = 1, ref = k; ref < n; i++, ref++) {
            aux = aux - nums[i - 1] + nums[ref];
            sum = Math.max(aux, sum);
        }

        return sum / k;
    }

    public static void main(String[] args) {
        int[] v = {1, 12, -5, -6, 50, 3};

        int[] v2 = {0, 1, 1, 3, 3};

        int[] v3 = {0, 4, 0, 3, 2};

        System.out.println(findMaxAverage(v3, 1));
    }
}
