package leetcode;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> triplets = new HashSet<>();

        int size = nums.length;

        for (int i = 0; i < size - 1; i++) {
            int j = i + 1;
            int k = size - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0)
                    j++;
                else if (sum > 0)
                    k--;
                else {
                    triplets.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
            }
        }

        result.addAll(triplets);
        return result;
    }

    public static void main(String[] args) {

        int[] input = {-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum(input));
    }
}
