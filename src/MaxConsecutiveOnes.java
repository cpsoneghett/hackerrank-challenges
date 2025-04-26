public class MaxConsecutiveOnes {

    public static int longestOnes(int[] nums, int k) {

        int maxLength = 0, countZero = 0, left = 0;

        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] == 0)
                countZero++;

            while (countZero > k) {
                if (nums[left] == 0)
                    countZero--;

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] v = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] v2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};

        System.out.println(longestOnes(v2, 3));
    }
}
