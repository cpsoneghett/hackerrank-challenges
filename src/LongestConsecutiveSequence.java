import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        Set<Integer> numSet = Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        int max = 0;

        for (int n : numSet) {
            if (!numSet.contains(n - 1)) {
                int count = 1;

                while (numSet.contains(n + count))
                    count++;

                max = Math.max(max, count);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] n = {100, 4, 100, 1, 2, 3};

        System.out.println(longestConsecutive(n));
    }
}
