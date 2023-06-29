import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

class Result {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */


    public static int sumNonAdjacent(int[] v) {
        return recursiveSum(v, 0, new HashMap<>());
    }

    private static int recursiveSum(int[] v, int i, Map<Integer, Integer> memo) {
        if (i >= v.length) return 0;

        if (memo.containsKey(i)) return memo.get(i);

        int sum = Math.max(v[i] + recursiveSum(v, i + 2, memo), recursiveSum(v, i + 1, memo));
        memo.put(i, sum);
        return sum;
    }

    public static BigInteger sumNonAdjacentIterative(int[] arr) {
        int n = arr.length;
        BigInteger[] dp = new BigInteger[n];
        Arrays.fill(dp, BigInteger.ZERO);
        dp[0] = BigInteger.valueOf(arr[0]);
        if (n == 1) return dp[0];
        dp[1] = BigInteger.valueOf(Math.max(arr[0], arr[1]));
        for (int i = 2; i < n; i++) {
            if (arr[i] >= 0) {
                dp[i] = dp[i - 2].add(BigInteger.valueOf(arr[i]));
            } else {
                dp[i] = dp[i - 1];
            }
            dp[i] = dp[i].max(dp[i - 1]);
        }
        return dp[n - 2];
    }

    public static BigInteger sumNonAdjacent2(int[] arr) {
/*
        if (arr == null || arr.length == 0) {
            return BigInteger.ZERO;
        }
        int n = arr.length;
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.valueOf(arr[0]);
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].max(dp[i - 2].add(BigInteger.valueOf(arr[i - 1])));
        }
        return dp[n];
   */

        if (arr == null || arr.length == 0) {
            return BigInteger.ZERO;
        }
        BigInteger prevPrev = BigInteger.ZERO;
        BigInteger prev = BigInteger.valueOf(arr[0]);
        for (int i = 2; i <= arr.length; i++) {
            BigInteger curr = prev.max(prevPrev.add(BigInteger.valueOf(arr[i - 1])));
            prevPrev = prev;
            prev = curr;
        }
        return prev;
    }

    public static BigInteger sumNonAdjacent3(int[] arr) {
        int n = arr.length;
        BigInteger[] dp = new BigInteger[n];
        Arrays.fill(dp, BigInteger.ZERO);
        dp[0] = BigInteger.valueOf(arr[0]);
        if (n == 1) return dp[0];
        dp[1] = BigInteger.valueOf(Math.max(arr[0], arr[1]));
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1];
            if (arr[i] >= 0) {
                dp[i] = dp[i].max(dp[i - 2].add(BigInteger.valueOf(arr[i])));
            }
        }
        return dp[n - 1];
    }

    public static BigInteger sumNonAdjacent4(int[] arr) {
        int n = arr.length;
        if (n == 1) return BigInteger.valueOf(arr[0]);
        BigInteger[] dp = new BigInteger[n];
        Arrays.fill(dp, BigInteger.ZERO);
        dp[0] = BigInteger.valueOf(arr[0]);
        dp[1] = BigInteger.valueOf(Math.max(arr[0], arr[1]));
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1];
            if (arr[i] >= 0) {
                dp[i] = dp[i].max(dp[i - 2].add(BigInteger.valueOf(arr[i])));
            }
        }
        return dp[n - 1];
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

//        int[] v = {1, 1, 3, 4, 5, 20};
//        int[] v2 = {-1, 3, 2, 7, -5, 10, 11};

//        Result.maxSubsetSum(v);


        Scanner scanner = new Scanner(new File("src/inputs/input.txt"));
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        long startTime = System.nanoTime();
        int res = Result.sumNonAdjacent(arr);
        long endTime = System.nanoTime();
        long elapsedTimeInNano = endTime - startTime;
        double elapsedTimeInSeconds = (double) elapsedTimeInNano / 1_000_000_000.0;

        System.out.println("Result 1: " + res);
        System.out.println("Elapsed time: " + elapsedTimeInNano);


        startTime = System.nanoTime();
        BigInteger res2 = Result.sumNonAdjacent2(arr);
        endTime = System.nanoTime();
        elapsedTimeInNano = endTime - startTime;
        elapsedTimeInSeconds = (double) elapsedTimeInNano / 1_000_000_000.0;

        System.out.println("Result 2: " + res2);
        System.out.println("Elapsed time: " + elapsedTimeInNano);

        startTime = System.nanoTime();
        BigInteger res3 = Result.sumNonAdjacent3(arr);
        endTime = System.nanoTime();
        elapsedTimeInNano = endTime - startTime;
        elapsedTimeInSeconds = (double) elapsedTimeInNano / 1_000_000_000.0;

        System.out.println("Result 3: " + res3);
        System.out.println("Elapsed time: " + elapsedTimeInNano);

        startTime = System.nanoTime();
        BigInteger res4 = Result.sumNonAdjacentIterative(arr);
        endTime = System.nanoTime();
        elapsedTimeInNano = endTime - startTime;
        elapsedTimeInSeconds = (double) elapsedTimeInNano / 1_000_000_000.0;

        System.out.println("Result 4: " + res4);
        System.out.println("Elapsed time: " + elapsedTimeInNano);

        startTime = System.nanoTime();
        BigInteger res5 = Result.sumNonAdjacent4(arr);
        endTime = System.nanoTime();
        elapsedTimeInNano = endTime - startTime;
        elapsedTimeInSeconds = (double) elapsedTimeInNano / 1_000_000_000.0;

        System.out.println("Result 5: " + res5);
        System.out.println("Elapsed time: " + elapsedTimeInNano);

        scanner.close();
    }


}
