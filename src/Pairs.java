import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Pairs {

    public static int pairs(int k, List<Integer> arr) {
        Set<Integer> set = new HashSet<>(arr);
        int count = 0;
        for(int num : arr) {
            if(set.contains(num + k))
                count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/pairs.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Pairs.pairs(k, arr);

        System.out.println(result);

        bufferedReader.close();
    }
}
