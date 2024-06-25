package leetcode.interview;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {

        int numZeros = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0)
                numZeros++;
            else {
                int aux = nums[i];
                nums[i] = 0;
                nums[i - numZeros] = aux;
            }
        }
    }

    public static void main(String[] args) {

        int[] v = {0, 1, 0, 3, 12};

        moveZeroes(v);
    }
}
