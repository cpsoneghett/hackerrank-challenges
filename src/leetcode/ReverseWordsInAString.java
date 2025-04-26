package leetcode;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }

    public static String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty())
                sb.append(words[i]).append(" ");
        }

        return sb.toString().trim();
    }
}
