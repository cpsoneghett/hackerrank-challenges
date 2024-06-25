package leetcode.interview.medium;

import java.util.*;

public class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> set;

    public RandomizedSet() {
        set = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {

        if (map.containsKey(val))
            return false;

        map.put(val, set.size());
        return set.add(val);
    }

    public boolean remove(int val) {

        if (!map.containsKey(val))
            return false;

        int index = map.get(val);
        int listSize = set.size();

        int lastVal = set.get(listSize - 1);
        set.add(index, lastVal);
        map.put(lastVal, index);
        set.remove(listSize - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        Random random = new Random();
        return set.get(random.nextInt(set.size()));
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(0));
        System.out.println(rs.remove(0));
        System.out.println(rs.insert(-1));
        System.out.println(rs.remove(0));
        System.out.println(rs.getRandom());
    }
}

class RandomizedSetNonOptimal {

    Set<Integer> set;

    public RandomizedSetNonOptimal() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        Random random = new Random();
        int rand = random.nextInt(set.size());

        for (int value : set) {
            if (rand <= 0)
                return value;

            rand--;
        }

        return 0;
    }
}
