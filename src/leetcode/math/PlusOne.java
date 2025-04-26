package leetcode.math;

public class PlusOne {

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int aux[] = new int[digits.length + 1];
        aux[0] = 1;
        return aux;
    }

    public static void main(String[] args) {
        int[] digits = {9};

        for (int d : plusOne(digits)) {
            System.out.print(d);
            System.out.print(" ");
        }

    }
}
