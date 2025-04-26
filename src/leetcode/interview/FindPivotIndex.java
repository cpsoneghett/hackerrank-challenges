package leetcode.interview;

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {

        int[] sumLeft = new int[nums.length];
        int[] sumRight = new int[nums.length];

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumLeft[i] = sum;
        }

        sum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            sumRight[i] = sum;
        }

        for (int i = 0; i < nums.length; i++) {
            if(sumLeft[i] == sumRight[i])
                return i;
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};

        System.out.println(pivotIndex(nums));
    }

}
