package june30;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RoadsAndLibraries {

    public static long roadsAndLibraries(int n, int cLib, int cRoad, List<List<Integer>> cities) {

        if (cLib <= cRoad)
            return (long) n * cLib;

        int[] parents = new int[n];
        for (int i = 0; i < n; i++)
            parents[i] = i;

        for (List<Integer> city : cities) {
            int c1 = city.get(0) - 1;
            int c2 = city.get(1) - 1;

            add2Union(parents, c1, c2);
        }

        Map<Integer, Integer> groupCount = new HashMap<>();
        for (int p : parents) {
            int parent = findParent(parents, p);
            groupCount.put(parent, groupCount.getOrDefault(parent, 0) + 1);
        }

        long res = 0;
        for(Map.Entry<Integer, Integer> entry : groupCount.entrySet()) {
            res += cLib;
            res += (long)(entry.getValue() - 1) * cRoad;
        }

        return res;
    }

    private static void add2Union(int[] parents, int c1, int c2) {
        int p1 = findParent(parents, c1);
        int p2 = findParent(parents, c2);

        if (p1 == p2)
            return;

        parents[p2] = p1;
    }

    private static int findParent(int[] parents, int c) {
        if (parents[c] == c)
            return c;

        int p = findParent(parents, parents[c]);
        parents[c] = p;
        return p;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/roads-n-libs.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = roadsAndLibraries(n, c_lib, c_road, cities);

                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }


}
