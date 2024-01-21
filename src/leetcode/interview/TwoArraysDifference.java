package leetcode.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoArraysDifference {

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> answer = new ArrayList<>();

        Set<Integer> nonRepeated1 = new HashSet<>();
        Set<Integer> nonRepeated2 = new HashSet<>();

        for (int num : nums1)
            nonRepeated1.add(num);
        for (int num : nums2)
            nonRepeated2.add(num);

        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();


        for (int num : nums1)
            if (!nonRepeated2.contains(num))
                list1.add(num);

        for (int num : nums2)
            if (!nonRepeated1.contains(num))
                list2.add(num);

        answer.add(new ArrayList<>(list1));
        answer.add(new ArrayList<>(list2));

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};

        System.out.println(findDifference(nums1, nums2));
    }
}
