package june30;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ClimbingTheLeaderboard {

    private static List<Integer> climbingLeaderboard2(List<Integer> ranked, List<Integer> player) {

        List<Integer> result = new ArrayList<>();
        List<Integer> ranks = ranked.stream().distinct().collect(Collectors.toUnmodifiableList());

        int pos = 1;

        for (int play : player) {

            for (int rank : ranks) {
                if (play >= rank) {
                    result.add(pos);
                    break;
                }
                ++pos;
            }

            if (result.isEmpty())
                result.add(pos);
            pos = 1;
        }

        return result;
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        List<Integer> result = new ArrayList<>(player.size());
        ranked = ranked.stream().distinct().sorted().collect(Collectors.toList());

        for (Integer play : player) {
            int index = Collections.binarySearch(ranked, play);
            if (index < 0) {
                index += ranked.size() + 2;
            } else {
                // index = ranked.size() + 1 + (-1)*(index + 1);
                index = ranked.size() + (-1)*(index);

            }
            result.add(index);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/leaderboard.txt"));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = climbingLeaderboard(ranked, player);

        System.out.println(result);

        bufferedReader.close();

    }


}
