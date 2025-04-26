package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";
        int maxPrefix = 0, minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        for (int i = 0; i < minLength; i++) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != ch) {
                    return str.substring(0, i);
                }
            }
            maxPrefix++;
        }
        if (maxPrefix > 0)
            return strs[0].substring(0, maxPrefix);
        else return "";
    }


    public static String longestCommonPrefix2(String[] strs) {

        StringBuilder sb = new StringBuilder();
        Set<Character> charSet = new HashSet<>();
        int index = 0;
        int minStringSize = strs[0].length();

        for (String s : strs)
            if (s.length() < minStringSize) minStringSize = s.length();

        while (index < minStringSize) {
            for (String s : strs)
                charSet.add(s.charAt(index));

            if (charSet.size() >= 2) break;

            index++;
            sb.append(charSet.stream().findFirst().get());
            charSet.clear();

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(strs));
    }
}
