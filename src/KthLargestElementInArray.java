import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < k; i++)
            minHeap.offer(nums[i]);

        for (int i = k; i < nums.length; i++) {
            if(nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }

    public static int findKthLargest2(int[] nums, int k) {

        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] v = {3, 2, 1, 5, 6, 4};
        int[] v2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] v3 = {2, 1};

        System.out.println(findKthLargest(v2, 4));
    }
}
