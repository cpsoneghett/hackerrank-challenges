package leetcode.interview.medium;

import java.util.Arrays;

public class HIndex {

    public static int hIndex(int[] citations) {

        Arrays.sort(citations);
        int result = 0;

        for (int i = (citations.length - 1); i > 0; i--) {

            if (citations[i] >= i)
                result = citations[i];
        }

        return result;
    }


    public static void main(String[] args) {
        int nums[] = {3, 0, 6, 1, 5};
        int nums2[] = {1, 3, 1};


        System.out.println(hIndex(nums));
    }
}
