package july03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {

        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (List<Integer> query : queries) {

            if (query.get(0) == 1) {
                if (!map.containsKey(query.get(1)))
                    map.put(query.get(1), 1);
                else
                    map.put(query.get(1), map.get(query.get(1)) + 1);
            } else if (query.get(0) == 2) {
                if (map.containsKey(query.get(1)))
                    map.put(query.get(1), map.get(query.get(1)) - 1);
            } else if (query.get(0) == 3) {
                int val = 0;
                for (Integer key : map.keySet()) {
                    Integer value = map.get(key);
                    if (value == query.get(1)) {
                        val = 1;
                        break;
                    }
                }
                ans.add(val);
            }
        }

        return ans;
    }

    static List<Integer> freqQuery2(List<List<Integer>> queries) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (List<Integer> query : queries) {
            int type = query.get(0);
            int value = query.get(1);
            int current = map.getOrDefault(value, 0);

            switch (type) {
                case 1 -> map.put(value, current + 1);
                case 2 -> {
                    if (current > 0)
                        map.put(value, current - 1);
                }
                case 3 -> {
                    final boolean contains = map.containsValue(value);
                    ans.add(contains ? 1 : 0);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/frequency-queries.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery2(queries);

        System.out.println(ans);

        bufferedReader.close();

    }
}
