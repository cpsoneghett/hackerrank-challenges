package leetcode;

public class MergeAlternately {

    public String mergeAlternately(String word1, String word2) {

        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        StringBuilder sb =  new StringBuilder();

        int size1 = word1.length();
        int size2 = word2.length();

        for(int i = 0;; i++) {

            if(i >= size1 && i >= size2)
                break;
            if(i<size1)
                sb.append(arr1[i]);
            if(i<size2)
                sb.append(arr2[i]);

        }

        return sb.toString();
    }

    public String mergeAlternately2(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int shorterLength = Math.min(len1, len2);
        StringBuilder sb = new StringBuilder(shorterLength);

        for (int i = 0; i < shorterLength; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if (len1 > len2) {
            sb.append(word1, shorterLength, len1);
        } else if (len2 > len1) {
            sb.append(word2, shorterLength, len2);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
