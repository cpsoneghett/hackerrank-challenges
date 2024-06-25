package leetcode.interview.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {

    public static String predictPartyVictory(String senate) {
        char[] senators = senate.toCharArray();
        int n = senators.length;

        Queue<Integer> rad = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senators[i] == 'R')
                rad.add(i);
            else
                dire.add(i);
        }

        while (!rad.isEmpty() && !dire.isEmpty()) {
            if(rad.peek() < dire.peek())
                rad.add(n++);
            else
                dire.add(n++);

            rad.poll();
            dire.poll();
        }


        return rad.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {

        System.out.println(predictPartyVictory("RDDDRDRDRRDRDRDDDRD"));

    }
}
