package leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {

        String[] split = s.split(" ");

        if (pattern.length() != split.length)
            return false;

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);

            if (map.containsKey(c)) {
                if (!map.get(c).equals(split[i]))
                    return false;
            } else if (map.containsValue(split[i]))
                return false;
            else
                map.put(c, split[i]);

        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";

        System.out.println(wordPattern(pattern, s));
    }
}
