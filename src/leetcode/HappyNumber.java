package leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static boolean isHappy(int n) {

        if (n == 1)
            return true;

        Set<Long> sums = new HashSet<>();

        long sum = 0l;
        long aux = n;

        while (sum != 1) {

            String s = String.valueOf(aux);

            for (int i = 0; i < s.length(); i++)
                sum += Math.pow((Integer.valueOf(s.charAt(i)) - 48), 2);

            if (sum == 1)
                return true;
            if (sums.contains(sum))
                return false;

            sums.add(sum);

            aux = sum;
            sum = 0;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(isHappy(2));
    }
}
