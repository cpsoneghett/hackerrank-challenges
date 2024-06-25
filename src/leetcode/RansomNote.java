package leetcode;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] map = new int[27];

        for (char c : magazine.toCharArray())
            map[c - 97]++;

        for (char c : ransomNote.toCharArray()) {
            map[c - 97]--;

            if (map[c - 97] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String ransomNote = "a";
        String magazine = "b";

        System.out.println(canConstruct(ransomNote, magazine));
    }
}
