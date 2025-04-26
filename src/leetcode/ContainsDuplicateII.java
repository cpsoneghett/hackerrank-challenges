package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            if (map.containsKey(curr)) {
                if (i - map.get(curr) <= k)
                    return true;
            }

            map.put(curr, i);
        }


        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 0, 1, 3};

        System.out.println(containsNearbyDuplicate(nums, 3));
    }
}
