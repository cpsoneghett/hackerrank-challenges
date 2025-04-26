package leetcode.math;

public class Palindrome {

    public static boolean isPalindrome(int x) {

        String s = String.valueOf(x);
        int begin = 0;
        int end = s.length() - 1;

        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end))
                return false;

            begin++;
            end--;
        }

        return true;
    }

    public static boolean isPalindromeMath(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int y = 0;
        for (; y < x; x /= 10) {
            y = y * 10 + x % 10;
        }
        return x == y || x == y / 10;
    }

    public static void main(String[] args) {

        int n = 121;

        System.out.println(isPalindromeMath(n));
    }
}
