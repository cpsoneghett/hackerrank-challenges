package june28;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MagicSquare {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/magic-square.txt"));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = formingMagicSquare(s);

        System.out.println(result);

        bufferedReader.close();
    }

    private static int formingMagicSquare(List<List<Integer>> s) {

        List<Integer> sums = new ArrayList<>();

        for (List<Integer> row : s) {
            sums.add(row.stream().mapToInt(Integer::intValue).sum());
        }

        for(int i = 0; i < 3; i++) {
            sums.add(s.get(0).get(i) + s.get(1).get(i) + s.get(2).get(i));
        }

        sums.add(s.get(0).get(0) + s.get(1).get(1) + s.get(2).get(2));

        System.out.println(s);
        System.out.println(sums);

        return 0;
    }
}
