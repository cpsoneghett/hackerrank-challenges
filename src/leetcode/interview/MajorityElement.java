package leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (n / 2))
                return entry.getKey();
        }

        return 0;
    }

    public int majorityElementOptimal(int[] nums) {

        int count = 0, candidate = 0;

        for (int num : nums) {
            if (count == 0)
                candidate = num;

            if (num == candidate)
                count++;
            else
                count--;

        }

        return candidate;
    }
}
