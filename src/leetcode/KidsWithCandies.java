package leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> answer = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            int totalCandies = candies[i] + extraCandies;

            boolean isHigher = true;
            for (int j = 0; j < candies.length; j++) {
                if(i!=j && totalCandies < candies[j])
                    isHigher = false;
            }

            answer.add(isHigher);

        }
        return answer;
    }

}
