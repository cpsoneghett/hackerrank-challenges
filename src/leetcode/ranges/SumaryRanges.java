package leetcode.ranges;

import java.util.ArrayList;
import java.util.List;

public class SumaryRanges {

    public static List<String> summaryRanges(int[] nums) {

        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<String> ans = new ArrayList<>();
        int ref = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1] + 1) {
                if (ref == nums[i - 1]) ans.add(String.valueOf(ref));
                else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(ref).append("->").append(nums[i - 1]);
                    ans.add(sb.toString());
                }

                ref = nums[i];
            }
        }

        if (ref == nums[nums.length - 1])
            ans.add(String.valueOf(ref));
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(ref).append("->").append(nums[nums.length - 1]);
            ans.add(sb.toString());
        }


        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 4, 5, 7};
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};

        System.out.println(summaryRanges(nums2));
    }
}
