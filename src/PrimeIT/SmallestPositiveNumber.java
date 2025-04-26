package PrimeIT;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveNumber {

    public static void main(String[] args) {
        int v[]= {-1,-3,-1,-4,-100};

        System.out.println(solution(v));
    }

    public static int solution(int[] A) {

        Set<Integer> set = new HashSet<>();

        for (int a : A) {
            if (a > 0)
                set.add(a);
        }

        for (int i = 1; i <= A.length + 1; i++) {
            if (!set.contains(i))
                return i;
        }

        return 1;
    }
}
