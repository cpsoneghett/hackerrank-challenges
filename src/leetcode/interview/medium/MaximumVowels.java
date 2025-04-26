package leetcode.interview.medium;

public class MaximumVowels {

    public static int maxVowels(String s, int k) {

        int maxVowels = 0;
        int n = s.length();

        for (int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i)))
                maxVowels++;
        }

        int ans = maxVowels;
        for (int i = k; i < s.length(); i++) {
            if(isVowel(s.charAt(i)))
                maxVowels++;
            if(isVowel(s.charAt(i - k)))
                maxVowels--;

            if(ans < maxVowels)
                ans = maxVowels;
        }

        return ans;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String s = "weallloveyou";
        String s2 = "abciiidef";
        String s3 = "aeiou";

        System.out.println(maxVowels(s, 7));
        System.out.println(maxVowels(s2, 3));
        System.out.println(maxVowels(s3, 2));
    }
}
