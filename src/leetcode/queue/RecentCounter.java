package leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        this.queue.add(t);
        //[t - 3000, t]
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }


    public static void main(String[] args) {

        int[] input = {1, 100, 3000, 3001};
        RecentCounter rc = new RecentCounter();

        for(int n : input)
            System.out.println(rc.ping(n));
    }
}
