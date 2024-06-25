package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    private Queue<Integer> requests;

    public RecentCounter() {
        this.requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.add(t);
        while (requests.peek() < t - 3000)
            requests.poll();

        return requests.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
        System.out.println(recentCounter.ping(3005));
        System.out.println(recentCounter.ping(4000));
        System.out.println(recentCounter.ping(4001));

    }
}
