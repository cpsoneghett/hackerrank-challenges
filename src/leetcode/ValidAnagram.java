package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        Map<Character, Long> mapS = new HashMap<>();
        Map<Character, Long> mapT = new HashMap<>();

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++)
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0l) + 1l);

        for (int i = 0; i < t.length(); i++)
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0l) + 1l);

        return mapS.equals(mapT);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
            letters[t.charAt(i) - 'a']--;
        }

        for (int num : letters) {
            if (num != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}
