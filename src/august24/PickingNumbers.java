package august24;

import java.util.List;

public class PickingNumbers {

    public static int pickingNumbers(List<Integer> a) {

        int[] frequency = new int[101]; // As per problem constraints

        for (int num : a)
            frequency[num]++;

        int maxLength = 0;

        for (int i = 1; i <= 100; i++) {
            maxLength = Math.max(maxLength, frequency[i] + frequency[i - 1]);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        List<Integer> a = List.of(1,1,2,2,4,4,5,5,5);
        System.out.println(pickingNumbers(a));

    }
}
