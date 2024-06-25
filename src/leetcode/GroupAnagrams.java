package leetcode;

import java.util.*;

public class GroupAnagrams {

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

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

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> answer = new ArrayList<>();

        if (strs.length == 0)
            return answer;

        if (strs.length == 1) {
            answer.add(List.of(strs[0]));
            return answer;
        }

        Map<String, List<String>> map = new HashMap<>();
        boolean control = false;

        for (String s : strs) {
            for (String key : map.keySet()) {
                if (isAnagram(s, key)) {
                    map.get(key).add(s);
                    control = true;
                }
            }

            if (!control) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(s, list);
            }

            control = false;
        }

        answer.addAll(map.values());

        return answer;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());

    }


    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams2(strs));
    }
}
