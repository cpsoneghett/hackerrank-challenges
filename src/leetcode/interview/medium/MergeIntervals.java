package leetcode.interview.medium;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge2(int[][] intervals) {

        if (intervals.length <= 1)
            return intervals;

        boolean keepMerging;
        List<int[]> ansList = new ArrayList<>();

        int[] previous = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];

            if (previous[0] >= current[0] && previous[0] <= current[1]) {
                previous[0] = current[0];
                previous[1] = Math.max(previous[1], current[1]);

                keepMerging = true;
            } else if (current[0] <= previous[1] && current[0] >= previous[0]) {
                previous[1] = Math.max(previous[1], current[1]);

                keepMerging = true;
            } else if (current[0] == previous[1] + 1) {
                previous[1] = current[1];
                keepMerging = true;
            } else
                keepMerging = false;

            if (!keepMerging) {
                ansList.add(previous);
                previous = current;
            }

            if (i == intervals.length - 1 && keepMerging)
                ansList.add(previous);
            else if (i == intervals.length - 1 && !keepMerging)
                ansList.add(current);

        }

        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] == interval[1]) {
                if (interval[0] < prev[0]) {
                    merged.add(interval);
                } else if (interval[0] > prev[1]) {
                    merged.add(prev);
                    prev = interval;
                }
            } else {
                if (interval[0] < prev[0])
                    prev[0] = interval[0];

                if (interval[0] <= prev[1])
                    prev[1] = Math.max(prev[1], interval[1]);
                else {
                    merged.add(prev);
                    prev = interval;
                }
            }


        }

        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals0 = {{1, 4}, {4, 4}, {2, 5}};

        int[][] intervals1 = {{1, 3}, {2, 6}, {5, 10}, {10, 11}, {11, 18}};
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] intervals3 = {{1, 4}, {2, 3}};
        int[][] intervals4 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        // merge(intervals1);
        merge(intervals0);

    }

}
