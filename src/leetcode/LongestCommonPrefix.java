package leetcode;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";

        StringBuilder ans = new StringBuilder();
        boolean endPrefix = true, control = true;
        int i = 0;

        while (endPrefix) {

            char c = !strs[0].isEmpty() ? strs[0].charAt(i) : '0';

            for (String s : strs) {

                if (c == '0' || i > s.length() || s.charAt(i) != c) {
                    control = false;
                    endPrefix = false;
                    break;
                }
            }

            if (control)
                ans.append(c);

            i++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{""};

        System.out.println(longestCommonPrefix(strs));
    }
}
