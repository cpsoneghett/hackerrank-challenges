package leetcode;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {

        int size = s.length();

        if (size != t.length())
            return false;

        int[] indexS = new int[200];
        int[] indexT = new int[200];

        for (int i = 0; i < s.length(); i++) {

            if (indexS[s.charAt(i)] != indexT[t.charAt(i)])
                return false;

            indexS[s.charAt(i)] = i + 1;
            indexT[t.charAt(i)] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
