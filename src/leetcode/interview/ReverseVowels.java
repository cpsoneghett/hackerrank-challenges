package leetcode.interview;

public class ReverseVowels {

    public static String reverseVowels(String s) {

        int size = s.length();
        int k = 0;
        char[] vowels = new char[size];
        StringBuilder sb = new StringBuilder();

        for (int i = size - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (isVowel(c)) {
                vowels[k] = c;
                k++;
            }
        }

        k = 0;

        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);

            if (isVowel(c)) {
                sb.append(vowels[k]);
                k++;
            } else
                sb.append(c);
        }


        return sb.toString();
    }

    private static boolean isVowel(char c) {
        String VOWELS = "aeiouAEIOU";

        return VOWELS.indexOf(c) != -1;
    }
}
