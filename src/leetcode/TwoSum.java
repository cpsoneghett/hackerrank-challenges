package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff))
                return new int[] {map.get(diff), i};

            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] ans = twoSum(nums, target);

        System.out.println(ans[0] + "-" + ans[1]);
    }
}
