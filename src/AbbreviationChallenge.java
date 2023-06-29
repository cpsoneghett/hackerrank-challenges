import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class AbbreviationChallenge {

    static Set<String> memo = new HashSet<>();
    static boolean possible;

    public static String abbreviation(String a, String b) {

        char[] s1 = a.trim().toCharArray();
        char[] s2 = b.trim().toCharArray();

        int rows = s2.length;
        int columns = s1.length;

        boolean[][] dp = new boolean[rows + 1][columns + 1];
        dp[0][0] = true;
        //Fill the first col
//        for (int row = 1; row <= rows; row++) {
//            dp[row][0] = false;
//        }

        // Fill the first row
        for (int col = 1; col < columns; col++) {
            if (Character.isLowerCase(s1[col - 1]))
                dp[0][col] = dp[0][col - 1];
            else
                dp[0][col] = false;
        }

        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= columns; col++) {
                if (Character.toUpperCase(s1[col - 1]) == s2[row - 1])
                    if (Character.isLowerCase(s1[col - 1]))
                        dp[row][col] = dp[row - 1][col - 1] ? dp[row - 1][col - 1] : dp[row][col - 1];
                    else
                        dp[row][col] = dp[row - 1][col - 1];

                else if (Character.isLowerCase(s1[col - 1]))
                    dp[row][col] = dp[row][col - 1];
                else
                    dp[row][col] = false;
            }
        }

        return dp[rows][columns] ? "YES" : "NO";
    }

    static String abbreviation2(String a, String b) {
        boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (dp[i][j]) {
                    if (j < b.length() && Character.toUpperCase(a.charAt(i)) == b.charAt(j)) {
                        dp[i + 1][j + 1] = true;
                    }
                    if (Character.isLowerCase(a.charAt(i))) {
                        dp[i + 1][j] = true;
                    }
                }
            }
        }
        return dp[a.length()][b.length()] ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test.txt"));
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String a = bufferedReader.readLine();

                String b = bufferedReader.readLine();

                String result = abbreviation2(a, b);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
