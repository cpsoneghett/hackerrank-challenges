import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DebugTest {

    public static int maxSubsetSum(int[] v) {
        int[] dp = new int[v.length];
        dp[1] = v[0];

        for (int i = 2; i < v.length; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(v[i - 1], dp[i - 2] + v[i - 1]));

        }

        return dp[v.length - 1];
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/test.txt"));
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println(maxSubsetSum(arr));
    }
}
