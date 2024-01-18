package july16;

import java.util.List;

public class PalindromeIndex {

    public static int palindromeIndex(String s) {

        int n = s.length();
        char[] str = s.toCharArray();
        int i, j = 0, x, y;

        for (i = 0; i < n / 2; i++) {
            j = n - 1 - i;
            if (s.charAt(i) != s.charAt(j))
                break;
        }
        if (i == n / 2) {
            if (n % 2 == 1) {
                System.out.println(n / 2);
            }
        }
        {
            for (x = i + 1, y = j; x < y; x++, y--) if (str[x] != str[y]) break;
            if (x >= y) System.out.println(i);
            else {
                for (x = i, y = j - 1; x < y; x++, y--) if (str[x] != str[y]) break;
                if (x >= y) System.out.println(j);
                else System.out.println(-1);
            }
        }


        return 0;
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        List<String> strings = List.of(
                "abba"
        );

        strings.forEach(s -> System.out.println(palindromeIndex(s)));
    }
}
