package leetcode.interview;

public class StringSubsequence {

    public static boolean isSubsequence(String s, String t) {

        int i = 0;

        for (int j = 0; j < t.length() && i < s.length(); j++)
            if (t.charAt(j) == s.charAt(i))
                i++;

        return i == s.length();
    }

    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";

        System.out.println(isSubsequence(s, t));
    }
}
