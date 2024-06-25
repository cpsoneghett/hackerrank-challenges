package leetcode.interview;

public class Palindrome {


    public static boolean isPalindrome(String s) {

        if (s.isEmpty())
            return true;

        int i = 0, j = s.length() - 1;

        while (i <= j) {
            char a = s.charAt(i);
            char b = s.charAt(j);

            if (!Character.isLetterOrDigit(a)) {
                i++;
            } else if (!Character.isLetterOrDigit(b)) {
                j--;
            } else {
                if (Character.toLowerCase(a) != Character.toLowerCase(b))
                    return false;

                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "race a car";
        String s1 = "A man, a plan, a canal: Panama";


        System.out.println(isPalindrome(s));
    }
}
