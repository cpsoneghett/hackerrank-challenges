package leetcode;

public class SingleNumber {

    public static int singleNumberI(int[] nums) {
        int xor = 0;

        for (int i : nums)
            xor ^= i;

        return xor;
    }

    public static void singleNumberII() {



    }

    public static void main(String[] args) {

        int nums[] = {2,2,1};

        System.out.println(singleNumberI(nums));
    }
}
