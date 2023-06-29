package june28;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MigratoryBirds {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/mig-birds.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int[] array = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = migratoryBirds(array);

        System.out.println(result);

        bufferedReader.close();

    }

    private static int migratoryBirds(int[] arr) {

        if (arr.length == 1)
            return arr[0];

        Map<Integer, Integer> map = new HashMap<>();
        int result = 0, sum = 0;

        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                map.put(1, map.get(1) + 1);
            } else if (arr[i] == 2) {
                map.put(2, map.get(2) + 1);
            } else if (arr[i] == 3) {
                map.put(3, map.get(3) + 1);
            } else if (arr[i] == 4) {
                map.put(4, map.get(4) + 1);
            } else {
                map.put(5, map.get(5) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if(value > sum) {
                sum = value;
                result = key;
            }
        }

        return result;
    }
}
