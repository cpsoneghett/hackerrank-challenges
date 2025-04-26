package PrimeIT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Concatenation {

    public static int solution(String[] A) {
        int result = 0;

        //Set to store the words with non-repeated letters
        List<String> words = new ArrayList<>();

        for (String s : A) {
            if (!hasRepeatedLetters(s))
                words.add(s);
        }

        for (int i = 0; i < words.size(); i++) {

            StringBuilder sb = new StringBuilder(words.get(i));

            for (int j = i + 1; j < words.size(); j++) {
                //String aux = words.get(i) + words.get(j);
                String aux = sb.append(words.get(j)).toString();
                int sizeAux = aux.length();

                if (!hasRepeatedLetters(aux)) {
                    if(sizeAux > result)
                        result = sizeAux;
                }
            }
        }


        return result;
    }

    private static boolean hasRepeatedLetters(String s) {

        char[] letters = s.toCharArray();
        Set<Character> set = new HashSet<>();

        for (char c : letters)
            set.add(c);

        return s.length() != set.size();
    }

    public static void main(String[] args) {
        String[] A = {"co", "dil", "ity"};
        String[] B = {"eva", "jwq", "tyn", "jan"};

        System.out.println(solution(A));
        System.out.println(solution(B));
    }
}
