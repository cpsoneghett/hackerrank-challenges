package leetcode.interview;

public class RotateArray {

    public static void rotate(int[] nums, int k) {

        int size = nums.length;
        int rotations = k >= size ? k % size : k;

        while (rotations > 0) {
            int aux = nums[size - 1];

            for (int i = size - 1; i >= 1; i--)
                nums[i] = nums[i - 1];

            nums[0] = aux;
            rotations--;
        }
    }

    public static void rotate2(int[] nums, int k) {

        int size = nums.length;
        int rotations = k >= size ? k % size : k;

        if (rotations == 0)
            return;

        int numsAux[] = new int[size];

        for (int i = 1; i <= rotations; i++)
            numsAux[rotations - i] = nums[size - i];


        for (int i = rotations, j = 0; i < size; i++, j++)
            numsAux[i] = nums[j];

        System.arraycopy(numsAux, 0, nums, 0, nums.length);

    }

    public static void main(String[] args) {

        int[] v = {1, 2, 3, 4, 5, 6, 7}; // 6 7 1 2 3 4 5

        rotate2(v, 3);

        for (int n : v)
            System.out.print(n);
    }
}
