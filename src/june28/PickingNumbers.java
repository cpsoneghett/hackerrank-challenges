package june28;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PickingNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/numbers.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = pickingNumbers(a);

        System.out.println(result);

        bufferedReader.close();

    }

    private static int pickingNumbers(List<Integer> a) {

        Collections.sort(a);

        int count = 0, ref = a.get(0);

        for (int i = 0; i < a.size(); i++) {
            if(Math.abs(a.get(i) - ref) < 2) {
                count++;
                ref = a.get(i);
            }
        }

        return count;
    }
}
