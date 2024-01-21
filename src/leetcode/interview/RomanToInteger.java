package leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    static Map<Character, Integer> romans = new HashMap<>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public static int romanToInt(String s) {

        int n = s.length();
        int sum = 0, ref = 0;

        for (int i = n - 1; i >= 0; i--) {

            int num = romans.get(s.charAt(i));

            if (num < ref)
                sum -= num;
            else
                sum += num;

            ref = num;
        }

        return sum;
    }

    public static void main(String[] args) {

        String s = "MCD";

        System.out.println(romanToInt(s));
    }
}
