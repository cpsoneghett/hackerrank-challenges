import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionAux {

    public static int sumNonAdjacentRecursive(int[] v) {
        return recursiveSum(v, 0, new HashMap<>());
    }

    private static int recursiveSum(int[] v, int i, Map<Integer, Integer> memo) {
        if (i >= v.length) return 0;

        if (memo.containsKey(i)) return memo.get(i);


        int sum = Math.max(v[i] + recursiveSum(v, i + 2, memo), recursiveSum(v, i + 1, memo));
        memo.put(i, sum);

        //System.out.println(memo.toString());
        return sum;
    }

    public static int sumNonAdjacentDynamic(int[] v) {
        int[] dp = new int[v.length];
        dp[0] = v[0];
        dp[1] = Math.max(v[0], v[1]);

        //System.out.printf("\ndp[0]:v0 = %d | dp[1]:max(v[0],v[1]:%d) = %d\n", dp[0], v[1], dp[1]);
        for (int i = 2; i < v.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + v[i]);
            //System.out.printf("i: %d | dp[%d] = %d | dp[%d] = %d | v[%d] = %d | dp[%d] + v[%d] = %d \n", i, i-1, dp[i-1], i-2, dp[i-2], i, v[i], i-2, i, dp[i - 2] + v[i]);
        }
        return dp[v.length - 1] + Math.abs(v[0]);
    }

    public static int maxSubsetSum(int[] v) {
        int[] dp = new int[v.length + 1];
        dp[1] = v[0];

        for (int i = 2; i <= v.length; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(v[i - 1], dp[i - 2] + v[i - 1]));

        }

        return dp[v.length];
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/test.txt"));
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        long startTime = System.nanoTime();
        int res = sumNonAdjacentRecursive(arr);
        long endTime = System.nanoTime();
        long elapsedTimeInNano = endTime - startTime;

        System.out.println("\nResult 1 sumNonAdjacentRecursive: " + res);
        System.out.println("Elapsed time: " + elapsedTimeInNano);


        System.out.println();

        startTime = System.nanoTime();
        int res2 = sumNonAdjacentDynamic(arr);
        endTime = System.nanoTime();
        elapsedTimeInNano = endTime - startTime;

        System.out.println("\nResult 2 sumNonAdjacentDynamic: " + res2);
        System.out.println("Elapsed time: " + elapsedTimeInNano);


        System.out.println();

        startTime = System.nanoTime();
        int res3 = maxSubsetSum(arr);
        endTime = System.nanoTime();
        elapsedTimeInNano = endTime - startTime;

        System.out.println("\nResult 3 maxSubsetSum: " + res3);
        System.out.println("Elapsed time: " + elapsedTimeInNano);

        scanner.close();
    }
}
