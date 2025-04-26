package PrimeIT;

import java.util.HashMap;
import java.util.Map;

public class Arrows {

    public static int solution(String S) {

        Map<Character, Integer> arrows = new HashMap<>();
        int biggest = 0, result = 0;
        char refChar = '0';

        for (char c : S.toCharArray()) {
            int qty = arrows.getOrDefault(c, 0);
            arrows.put(c, qty + 1);

            if (arrows.get(c) > biggest) {
                biggest = arrows.get(c);
                refChar = c;
            }
        }

        for (Map.Entry<Character, Integer> arrow : arrows.entrySet()) {
            if (arrow.getKey() != refChar) {
                result += arrow.getValue();
            }
        }


        return result;
    }

    public static void main(String[] args) {
        String s = "^vv<v";

        System.out.println(solution(s));
    }
}
