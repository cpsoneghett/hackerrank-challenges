package july03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {

        Map<Long, Long> left = new LinkedHashMap<>();
        Map<Long, Long> right = new LinkedHashMap<>();

        Long result = 0l;

        for (Long element : arr)
            right.put(element, right.getOrDefault(element, 0l) + 1);

        for (Long num : arr) {
            if (right.getOrDefault(num, 0l) > 0)
                right.put(num, right.get(num) - 1);

            if (num % r == 0)
                result += right.getOrDefault(num * r, 0l) * left.getOrDefault(num / r, 0l);

            left.put(num, left.getOrDefault(num, 0l) + 1);
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/triplets.txt"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong).collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(ans);

        bufferedReader.close();
    }
}
