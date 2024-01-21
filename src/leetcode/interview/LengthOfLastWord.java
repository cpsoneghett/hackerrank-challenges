package leetcode.interview;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {

        String[] words = s.split(" ");
        int size = words.length;

        for (int i = size - 1; i >= 0; i--) {
            if (!words[i].isBlank())
                return words[i].length();
        }

        return 0;
    }

    public static int lengthOfLastWordOptimal(String s) {

        s = s.trim();

        int index = -1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                index = i;
                break;
            }
        }
        return s.length() - index - 1;
    }

    public static int lengthOfLastWordOptimal2(String s) {

        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                count++;

            if (s.charAt(i) == ' ' && count > 0)
                break;

        }
        return count;
    }

    public static void main(String[] args) {

    }
}
