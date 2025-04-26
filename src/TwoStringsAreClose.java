import java.util.*;

public class TwoStringsAreClose {

    public static Map<Character, Integer> countLetters(String input) {
        Map<Character, Integer> letterCounts = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
        }
        return letterCounts;
    }

    private static Map<Integer, Integer> countValues(Collection<Integer> values) {
        Map<Integer, Integer> valuesCounts = new HashMap<>();

        for (int i : values)
            valuesCounts.put(i, valuesCounts.getOrDefault(i, 0) + 1);

        return valuesCounts;
    }

    public static boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length())
            return false;

        if(word1.equals(word2))
            return true;

        Map<Character, Integer> word1Map = countLetters(word1);
        Map<Character, Integer> word2Map = countLetters(word2);

        if(!word1Map.keySet().equals(word2Map.keySet()))
            return false;

        Map<Integer, Integer> valueCounts1 = new HashMap<>();
        Map<Integer, Integer> valueCounts2 = new HashMap<>();

        for (int count : word1Map.values())
            valueCounts1.put(count, valueCounts1.getOrDefault(count, 0) + 1);

        for (int count : word2Map.values())
            valueCounts2.put(count, valueCounts2.getOrDefault(count, 0) + 1);

        return valueCounts1.equals(valueCounts2);
    }

    public static boolean closeStrings2(String word1, String word2) {

        if (word1.length() != word2.length())
            return false;

        if(word1.equals(word2))
            return true;

        Map<Character, Integer> word1Map = countLetters(word1);
        Map<Character, Integer> word2Map = countLetters(word2);

        if(!word1Map.keySet().equals(word2Map.keySet()))
            return false;

        int maxLength = word1.length() + 1; // Maximum possible count is word length
        int[] valueCounts1 = new int[maxLength];
        int[] valueCounts2 = new int[maxLength];

        for (int count : word1Map.values())
            valueCounts1[count]++;

        for (int count : word2Map.values())
            valueCounts2[count]++;

        for (int i = 0; i < maxLength; i++) {
            if (valueCounts1[i] != valueCounts2[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String word1 = "abbzzca"; //a=2, b=2, z=2
        String word2 = "babzzcz"; //a=1, b=2, z=3

        String word3 = "aaabbbbccddeeeeefffff"; // a=3 b=4 c=2 d=2 e=5 f=5    2x2 3x1 4x1 5x2
        String word4 = "aaaaabbcccdddeeeeffff"; // a=5 b=2 c=3 d=3 e=4 f=4    2x1 3x2 4x2 5x1


        System.out.println(closeStrings(word1, word2)); // false
        System.out.println(closeStrings(word3, word4));
    }
}
